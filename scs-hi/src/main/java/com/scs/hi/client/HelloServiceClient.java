package com.scs.hi.client;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scs.hi.client.hystrix.HelloServiceClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cxf
 * @date 2020-4-11
 */
@FeignClient(name = "hello",fallback = HelloServiceClientHystrix.class)
public interface HelloServiceClient {

    @GetMapping("/api/v1/hello/sayHello")
    String sayHello();

    @GetMapping("/api/v1/hello/sayHelloHystrix")
    String sayHelloHystrix();
}