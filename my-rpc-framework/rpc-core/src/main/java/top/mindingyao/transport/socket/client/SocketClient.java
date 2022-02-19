package top.mindingyao.transport.socket.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.mindingyao.entity.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Socket方式远程方法调用的消费者（客户端）
 */
public class SocketClient {
//    private static final Logger logger = LoggerFactory.getLogger(SocketClient.class);
//
//    public Object sendMessage(RpcRequest rpcRequest, String host, int port) {
//        try (Socket socket = new Socket(host, port)){
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//            objectOutputStream.writeObject(rpcRequest);
//            objectOutputStream.flush();
//            return objectInputStream.readObject();
//
//        } catch (IOException | ClassNotFoundException e) {
//            logger.error("调用时发生错误：" + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
}
