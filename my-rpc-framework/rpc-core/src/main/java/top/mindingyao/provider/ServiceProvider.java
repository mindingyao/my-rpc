package top.mindingyao.provider;

/**
 * 服务注册接口
 */
public interface ServiceProvider {
    <T> void addServiceProvider(T service, String serviceName);
    Object getServiceProvider(String serviceName);
}
