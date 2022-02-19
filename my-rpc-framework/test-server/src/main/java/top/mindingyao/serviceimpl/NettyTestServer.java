package top.mindingyao.serviceimpl;

import top.mindingyao.annotation.ServiceScan;
import top.mindingyao.api.HelloService;
import top.mindingyao.provider.ServiceProvider;
import top.mindingyao.serializer.CommonSerializer;
import top.mindingyao.transport.RpcServer;
import top.mindingyao.transport.netty.server.NettyServer;

@ServiceScan
public class NettyTestServer {

    public static void main(String[] args) {
        RpcServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
    }

}
