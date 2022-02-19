package top.mindingyao.loadbalancer;

import top.mindingyao.entity.RpcRequest;

import java.util.List;
import java.util.Random;

public class RandomLoadBalancer extends AbstractLoadBalance{
    @Override
    protected String doSelect(List<String> serviceAddresses, RpcRequest rpcRequest) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}
