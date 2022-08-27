package cuit.epoch.pymjl;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/25 12:47
 **/
@SpringBootApplication
@EnableDubbo
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
