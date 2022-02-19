package top.mindingyao.registry;

import top.mindingyao.entity.RpcRequest;

import java.net.InetSocketAddress;

/**
 * 服务发现接口
 */
public interface ServiceDiscovery {
    /**
     * 根据服务名称查找服务实体
     */
    InetSocketAddress lookupService(RpcRequest rpcRequest);
}
