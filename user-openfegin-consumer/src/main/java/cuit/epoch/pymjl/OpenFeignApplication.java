package cuit.epoch.pymjl;

import cuit.epoch.pymjl.config.OpenFeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/31 23:37
 **/
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = OpenFeignConfig.class)
public class OpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class, args);
    }
}
