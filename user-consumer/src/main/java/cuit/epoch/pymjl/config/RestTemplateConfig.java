package cuit.epoch.pymjl.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 在这里配置我们自定义的LoadBalancer策略 如果想自己扩展算法 需要实现ReactorServiceInstanceLoadBalancer接口
 * /@LoadBalancerClients(defaultConfiguration = {name = "CLOUD-PAYMENT-SERVICE", configuration = MyLoadBalancerConfig.class})
 * 注意这里的name属性 需要和Nacos页面中的服务提供者名字一致
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/26 12:20
 **/
@Configuration
@LoadBalancerClient(name = "UserService", configuration = MyLoadBalancerConfig.class)
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
