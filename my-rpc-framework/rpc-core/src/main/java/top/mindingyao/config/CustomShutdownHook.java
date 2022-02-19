package top.mindingyao.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.mindingyao.factory.ThreadPoolFactory;
import top.mindingyao.registry.zk.util.CuratorUtils;
import top.mindingyao.transport.RpcServer;
import top.mindingyao.transport.netty.server.NettyServer;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;

@Slf4j
public class CustomShutdownHook {

    private static final Logger logger = LoggerFactory.getLogger(CustomShutdownHook.class);

    private static final CustomShutdownHook shutdownHook = new CustomShutdownHook();

    public static CustomShutdownHook getShutdownHook() {
        return shutdownHook;
    }

    public void clearAll() {
        logger.info("关闭后将自动注销所有服务");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            CuratorUtils.clearRegistry(CuratorUtils.getZkClient());
            ThreadPoolFactory.shutDownAll();
        }));
    }
}

