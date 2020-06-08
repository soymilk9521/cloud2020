package com.lr.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/06/09 6:47
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_guonei",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .route("path_route_guoji",
                        r -> r.path("/guoji")
                                .uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }
}
