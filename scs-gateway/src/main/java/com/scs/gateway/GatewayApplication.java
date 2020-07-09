package com.scs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableWebFlux
public class GatewayApplication {
	
	public static void main(String[] args) {
    	SpringApplication.run(GatewayApplication.class, args);
        System.out.println("网关启动成功...");
	}	
	

	@Configuration
	public class RouteConfiguration {
	    //这里为支持的请求头，如果有自定义的header字段请自己添加（不知道为什么不能使用*）
	    private static final String ALLOWED_HEADERS = "access-token, Access-Token, x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN,token,username,client";
	    private static final String ALLOWED_METHODS = "*";
	    private static final String ALLOWED_ORIGIN = "*";
	    private static final String ALLOWED_EXPOSE = "*";
	    private static final String MAX_AGE = "18000L";

	    @Bean
	    public WebFilter corsFilter() {
	        return (ServerWebExchange ctx, WebFilterChain chain) -> {
	            ServerHttpRequest request = ctx.getRequest();
	            if (CorsUtils.isCorsRequest(request)) {
	                ServerHttpResponse response = ctx.getResponse();
	                HttpHeaders headers = response.getHeaders();
	                headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
	                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
	                headers.add("Access-Control-Max-Age", MAX_AGE);
	                headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
	                headers.add("Access-Control-Expose-Headers", ALLOWED_EXPOSE);
	                headers.add("Access-Control-Allow-Credentials", "true");
	                if (request.getMethod() == HttpMethod.OPTIONS) {
	                    response.setStatusCode(HttpStatus.OK);
	                    return Mono.empty();
	                }
	            }
	            return chain.filter(ctx);
	        };
	    }
	    /**
	    *
	    *如果使用了注册中心（如：Eureka），进行控制则需要增加如下配置
	    */
	    @Bean
	    /**
	     * 路由定义信息的定位器，
	     * 负责读取路由配置( org.springframework.cloud.gateway.route.RouteDefinition
	     * 子类实现类
	     *  1.CachingRouteDefinitionLocator -RouteDefinitionLocator包装类， 缓存目标RouteDefinitionLocator 为routeDefinitions提供缓存功能
	     *  2.CompositeRouteDefinitionLocator -RouteDefinitionLocator包装类，组合多种 RouteDefinitionLocator 的实现，为 routeDefinitions提供统一入口
	     *  3.PropertiesRouteDefinitionLocator-从配置文件(GatewayProperties 例如，YML / Properties 等 ) 读取RouteDefinition
	     *  4.DiscoveryClientRouteDefinitionLocator-从注册中心( 例如，Eureka / Consul / Zookeeper / Etcd 等 )读取RouteDefinition
	     *  5.RouteDefinitionRepository-从存储器( 例如，内存 / Redis / MySQL 等 )读取RouteDefinition
	     */
	    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
	        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, new DiscoveryLocatorProperties());
	    }
	}
}
