package cuit.epoch.pymjl.config;

import com.alibaba.cloud.nacos.loadbalancer.NacosLoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


/**
 * 注意不要加@Configuration
 *
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/26 13:05
 **/
public class MyLoadBalancerConfig {
//    @Resource
//    NacosDiscoveryProperties nacosDiscoveryProperties;

    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//         随机轮询
        return new RandomLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(name, ServiceInstanceListSupplier.class),
                name);
        // 轮询
//        return new RoundRobinLoadBalancer(loadBalancerClientFactory
//                .getLazyProvider(name, ServiceInstanceListSupplier.class), name);
////        // Nacos权重轮询
//        return new NacosLoadBalancer(loadBalancerClientFactory
//                .getLazyProvider(name, ServiceInstanceListSupplier.class), name, nacosDiscoveryProperties);
    }
}
