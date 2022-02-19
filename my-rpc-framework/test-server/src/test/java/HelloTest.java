import top.mindingyao.api.HelloObject;
import top.mindingyao.api.HelloService;
import top.mindingyao.serviceimpl.HelloServiceImpl;

public class HelloTest {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloObject helloObject = new HelloObject(12, "This is a message");
        System.out.println(helloService.hello(helloObject));
    }
}
