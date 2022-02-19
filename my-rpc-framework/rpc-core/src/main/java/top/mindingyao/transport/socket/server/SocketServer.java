package top.mindingyao.transport.socket.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.mindingyao.handler.RequestHandler;
import top.mindingyao.provider.ServiceProvider;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Socket方式远程方法调用的提供者（服务端）
 */
public class SocketServer {
//    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);
//
//    private static final int CORE_POOL_SIZE = 5;
//    private static final int MAXIMUM_POOL_SIZE = 50;
//    private static final int KEEP_ALIVE_TIME = 60;
//    private static final int BLOCKING_QUEUE_CAPACITY = 100;
//    private final ExecutorService threadPool;
//    private final ServiceProvider serviceProvider;
//    private final RequestHandler requestHandler = new RequestHandler();
//
//    public SocketServer(ServiceProvider serviceProvider) {
//        this.serviceProvider = serviceProvider;
//        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);
//        ThreadFactory threadFactory = Executors.defaultThreadFactory();
//        threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, workingQueue, threadFactory);
//    }
//
//    public void start(int port) {
//        try (ServerSocket serverSocket = new ServerSocket(port)){
//            logger.info("服务器正在启动...");
//            Socket socket;
//            while((socket = serverSocket.accept()) != null) {
//                logger.info("消费者连接:{}:{}", socket.getInetAddress(), socket.getPort());
//                threadPool.execute(new RequestHandlerThread(socket, requestHandler, serviceProvider));
//            }
//
//        } catch (IOException e) {
//            logger.error("连接时发生错误：" + e.getMessage());
//            e.printStackTrace();
//        }
//    }
}

/**
class WorkerThread implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(WorkerThread.class);

    private Socket socket;
    private Object service;

    public WorkerThread(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            System.out.println(rpcRequest.getInterfaceName());
            System.out.println(rpcRequest.getMethodName());
            System.out.println(rpcRequest.getParameters().toString());
            System.out.println(rpcRequest.getParamTypes().toString());
            Method method = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamTypes());
            Object returnObject = method.invoke(service, rpcRequest.getParameters());
            objectOutputStream.writeObject(RpcResponse.success(returnObject));
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            logger.error("调用或发送时有错误发生：", e);
        }
    }

}
*/