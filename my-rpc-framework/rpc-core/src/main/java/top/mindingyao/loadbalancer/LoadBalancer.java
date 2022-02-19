package top.mindingyao.loadbalancer;

import top.mindingyao.entity.RpcRequest;

import java.util.List;

/**
 * 负载均衡策略接口
 */
public interface LoadBalancer {
    String selectServiceAddress(List<String> serviceAddresses, RpcRequest rpcRequest);
}
