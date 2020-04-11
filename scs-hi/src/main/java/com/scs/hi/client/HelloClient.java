package com.scs.hi.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cxf
 * @date 2020-4-11
 */
@FeignClient(name = "hello")
public interface HelloClient {

    @GetMapping("/api/v1/hello/sayHello")
    String sayHello();
}