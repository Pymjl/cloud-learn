package cuit.epoch.pymjl.controller;

import cuit.epoch.pymjl.result.CommonResult;
import cuit.epoch.pymjl.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/25 12:48
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public CommonResult<String> test() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        return ResultUtils.success(hostAddress);
    }

}
