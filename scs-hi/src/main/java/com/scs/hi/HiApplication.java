package com.scs.hi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
public class HiApplication {

	public static void main( String[] args ){
        SpringApplication.run(HiApplication.class, args);
        System.out.println( "HiApplication Start Success..." );
    }

}
