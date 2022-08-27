package cuit.epoch.pymjl;

import cuit.epoch.pymjl.entity.User;
import cuit.epoch.pymjl.mapper.UserMapper;
import cuit.epoch.pymjl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/25 22:53
 **/
@SpringBootTest
public class UserServiceContext {
    @Resource
    UserMapper userMapper;
    @Resource
    UserService userService;

    @Value("${server.port}")
    private String port;

    @Test
    void testHost() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress() + ":" + port);
    }

    @Test
    void testRegister() {
        User user = new User();
        user.setEmail("pymjl@qq.com");
        user.setUsername("pymjl");
        user.setPassword("123456");
        user.setPhone("110123012321093");
        userMapper.insert(user);
    }

    @Test
    void testUserService() {
        userService.register();

    }

}
