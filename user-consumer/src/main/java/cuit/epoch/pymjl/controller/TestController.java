package cuit.epoch.pymjl.controller;

import cuit.epoch.pymjl.entity.User;
import cuit.epoch.pymjl.result.CommonResult;
import cuit.epoch.pymjl.result.ResultUtils;
import cuit.epoch.pymjl.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/26 12:17
 **/
@RestController
@RequestMapping("/consumer")
public class TestController {
    private static final String SERVICE_URL = "http://user-service";

    @Resource
    RestTemplate restTemplate;

    @DubboReference
    UserService userService;

    @GetMapping("/test")
    public CommonResult consumerTest() {
        return restTemplate.getForObject(SERVICE_URL + "/user/test", CommonResult.class);
    }

    @GetMapping("/register")
    public CommonResult<String> register() {
        userService.register();
        return ResultUtils.success();
    }

    @GetMapping("/get/{id}")
    public CommonResult<User> get(@PathVariable("id") Long id) {
        return ResultUtils.success(userService.get(id));
    }
}
