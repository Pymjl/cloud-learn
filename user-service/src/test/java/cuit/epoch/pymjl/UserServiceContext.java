package cuit.epoch.pymjl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/25 22:53
 **/
@SpringBootTest
public class UserServiceContext {
    @Value("${server.port}")
    private String port;

    @Test
    void testHost() throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress() + ":" + port);
    }
}
