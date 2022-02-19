package top.mindingyao;

import top.mindingyao.api.HelloObject;
import top.mindingyao.transport.RpcClient;
import top.mindingyao.transport.RpcClientProxy;
import top.mindingyao.api.HelloService;
import top.mindingyao.transport.netty.client.NettyClient;

/**
 * 测试用消费者（客户端）
 */
public class TestClient {
    public static void main(String[] args) {
//        RpcClient client = new NettyClient("127.0.0.1", 9999);
//        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
//        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
//        HelloObject object = new HelloObject(12, "This is a message");
//        String res = helloService.hello(object);
//        System.out.println(res);
    }
}
