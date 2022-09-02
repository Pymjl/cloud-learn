package cuit.epoch.pymjl.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Pymjl
 * @version 1.0
 * @date 2022/9/2 17:02
 **/
@Component
@Log4j2
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=====================come in MyGlobalFilter==========================");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.error("用户名为null，非法用户");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 得到权重，order越小，优先级越高
     *
     * @return int
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
