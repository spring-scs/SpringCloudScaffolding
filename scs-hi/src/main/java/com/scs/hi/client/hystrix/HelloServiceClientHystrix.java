package com.scs.hi.client.hystrix;


import com.scs.hi.client.HelloServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author cxf
 * @date 2020-4-11
 */
@Component
@Slf4j
public class HelloServiceClientHystrix implements HelloServiceClient {

    @Override
    public String sayHello() {
        log.info("HelloServiceClientHystrix Fegin Error");
        return "HelloService请求失败，进入熔断处理！";
    }
}