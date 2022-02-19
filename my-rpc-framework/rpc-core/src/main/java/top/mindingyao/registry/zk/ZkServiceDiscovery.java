package top.mindingyao.registry.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import top.mindingyao.entity.RpcRequest;
import top.mindingyao.enumeration.RpcError;
import top.mindingyao.exception.RpcException;
import top.mindingyao.loadbalancer.LoadBalancer;
import top.mindingyao.loadbalancer.RandomLoadBalancer;
import top.mindingyao.registry.ServiceDiscovery;
import top.mindingyao.registry.zk.util.CuratorUtils;

import java.net.InetSocketAddress;
import java.util.List;

@Slf4j
public class ZkServiceDiscovery implements ServiceDiscovery {

    private final LoadBalancer loadBalancer;

    public ZkServiceDiscovery(LoadBalancer loadBalancer) {
        if(loadBalancer == null) {
            this.loadBalancer = new RandomLoadBalancer();
        }
        else {
            this.loadBalancer = loadBalancer;
        }
    }

    @Override
    public InetSocketAddress lookupService(RpcRequest rpcRequest) {
        String serviceName = rpcRequest.getInterfaceName();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlList = CuratorUtils.getChildrenNodes(zkClient, serviceName);
        if (serviceUrlList == null || serviceUrlList.size() == 0) {
            log.error("找不到对应服务：" + serviceName);
            throw new RpcException(RpcError.SERVICE_NOT_FOUND, serviceName);
        }
        // load balancing
        String targetServiceUrl = loadBalancer.selectServiceAddress(serviceUrlList, rpcRequest);
        log.info("Successfully found the service address:[{}]", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);
    }
}
