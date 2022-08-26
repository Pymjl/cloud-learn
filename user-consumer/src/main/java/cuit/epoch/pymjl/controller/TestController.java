package cuit.epoch.pymjl.controller;

import cuit.epoch.pymjl.result.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    private static final String SERVICE_URL = "http://UserService";

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/test")
    public CommonResult consumerTest() {
        return restTemplate.getForObject(SERVICE_URL + "/user/test", CommonResult.class);
    }
}
