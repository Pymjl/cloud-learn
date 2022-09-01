package cuit.epoch.pymjl.service;

import cuit.epoch.pymjl.entity.User;
import cuit.epoch.pymjl.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/9/1 0:03
 **/
@FeignClient(value = "user-service")
public interface UserFeignClient {
    /**
     * 注册
     *
     * @return {@code CommonResult<String>}
     */
    @GetMapping("/user/register")
    CommonResult<String> register();

    /**
     * 得到
     *
     * @param id id
     * @return {@code CommonResult<User>}
     */
    @GetMapping("/user/get/{id}")
    CommonResult<User> get(@PathVariable("id") Long id);
}
