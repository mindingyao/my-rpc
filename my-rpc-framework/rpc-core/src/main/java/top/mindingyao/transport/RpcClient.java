package top.mindingyao.transport;

import top.mindingyao.entity.RpcRequest;

public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);
}
