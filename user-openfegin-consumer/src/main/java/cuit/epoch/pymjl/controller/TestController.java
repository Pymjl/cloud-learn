package cuit.epoch.pymjl.controller;

import cuit.epoch.pymjl.entity.User;
import cuit.epoch.pymjl.result.CommonResult;
import cuit.epoch.pymjl.service.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/9/1 0:09
 **/
@RestController
@RequestMapping("/consumer")
public class TestController {
    @Resource
    UserFeignClient userFeignClient;

    @GetMapping("/register")
    public CommonResult<String> register() {
        return userFeignClient.register();
    }

    @GetMapping("/get/{id}")
    public CommonResult<User> get(@PathVariable Long id) {
        return userFeignClient.get(id);
    }


}
