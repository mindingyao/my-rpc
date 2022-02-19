package top.mindingyao.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.mindingyao.annotation.Service;
import top.mindingyao.api.HelloObject;
import top.mindingyao.api.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    public String hello(HelloObject object) {
        logger.info("已接收到消息：" + object.getMessage());
        return "这是HelloServiceImpl调用的返回值： id = " + object.getId();
    }
}
