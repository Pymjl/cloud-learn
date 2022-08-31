package cuit.epoch.pymjl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/8/31 20:15
 **/
@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigController {
    @Value("${config.info:default}")
    private String info;

    @GetMapping("/info")
    public String getInfo() {
        return info;
    }
}
