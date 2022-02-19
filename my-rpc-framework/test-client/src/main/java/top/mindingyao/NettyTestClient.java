package top.mindingyao;

import top.mindingyao.api.ByeService;
import top.mindingyao.api.HelloObject;
import top.mindingyao.api.HelloService;
import top.mindingyao.serializer.CommonSerializer;
import top.mindingyao.transport.RpcClient;
import top.mindingyao.transport.netty.client.NettyClient;
import top.mindingyao.transport.RpcClientProxy;

public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        for(int i=0; i<3; i++) {
            String res = helloService.hello(object);
            System.out.println(res);
        }
        for (int i = 0; i < 3; i++) {
            ByeService byeService = rpcClientProxy.getProxy(ByeService.class);
            System.out.println(byeService.bye("Netty"));
        }
    }

}

