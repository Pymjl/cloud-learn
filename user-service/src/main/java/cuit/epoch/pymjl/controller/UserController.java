package cuit.epoch.pymjl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import cuit.epoch.pymjl.entity.User;
import cuit.epoch.pymjl.result.CommonResult;
import cuit.epoch.pymjl.result.ResultUtils;
import cuit.epoch.pymjl.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/25 12:48
 **/
@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {
    @Resource
    UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    @SentinelResource(value = "test", blockHandler = "handleTest")
    public CommonResult<String> test(HttpServletRequest request) throws UnknownHostException {
        System.out.printf("被[/%s:%s]调用了一次%n", request.getRemoteHost(), request.getRemotePort());
        String hostAddress = InetAddress.getLocalHost().getHostAddress() + ":" + port;
        return ResultUtils.success(hostAddress);
    }

    @GetMapping("/register")
    @SentinelResource("register")
    public CommonResult<String> register() {
        userService.register();
        return ResultUtils.success();
    }

    @GetMapping("/get/{id}")
    @SentinelResource(value = "getUser")
    public CommonResult<User> get(@PathVariable("id") Long id) {
        return ResultUtils.success(userService.get(id));
    }

    public CommonResult<String> handleTest(HttpServletRequest request, BlockException blockException) {
        log.error("调用/user/test失败");
        return ResultUtils.fail("Sentinel流控，调用失败");
    }

}
