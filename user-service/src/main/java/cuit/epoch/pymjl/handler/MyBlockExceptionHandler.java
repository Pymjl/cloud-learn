package cuit.epoch.pymjl.handler;

import cn.hutool.json.JSONUtil;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import cuit.epoch.pymjl.result.CommonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/9/4 19:57
 **/
@Component
@Log4j2
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e)
            throws Exception {
        //getRule返回资源、规则的详细信息
        log.error("BlockExceptionHandler BlockException================" + e.getRule());
        CommonResult<String> result = new CommonResult<>();
        result.setSucceed(false);
        if (e instanceof FlowException) {
            result.setMessage("接口被限流了");
        } else if (e instanceof DegradeException) {
            result.setMessage("服务降级了");
        } else if (e instanceof ParamFlowException) {
            result.setMessage("热点参数被限流了");
        } else if (e instanceof AuthorityException) {
            result.setMessage("授权规则不通过");
        }
        //返回Json数据
        httpServletResponse.setStatus(500);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        try (PrintWriter writer = httpServletResponse.getWriter()) {
            writer.write(JSONUtil.toJsonPrettyStr(result));
            writer.flush();
        } catch (IOException ioException) {
            log.error("异常：{}", ioException.toString());
        }
    }
}
