package cuit.epoch.pymjl.feign;

import cuit.epoch.pymjl.constant.ResultEnum;
import cuit.epoch.pymjl.entity.User;
import cuit.epoch.pymjl.result.CommonResult;
import cuit.epoch.pymjl.result.ResultUtils;
import cuit.epoch.pymjl.service.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/9/17 22:06
 **/
@Component
public class FeignServiceFallback implements UserFeignClient {
    @Override
    public CommonResult<String> register() {
        return ResultUtils.fail(ResultEnum.SENTINEL_FALLBACK_ERROR);
    }

    @Override
    public CommonResult<User> get(Long id) {
        return ResultUtils.fail(ResultEnum.SENTINEL_FALLBACK_ERROR);
    }
}
