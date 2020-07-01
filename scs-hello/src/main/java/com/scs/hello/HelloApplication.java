package com.scs.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class HelloApplication {

	public static void main( String[] args ){
        SpringApplication.run(HelloApplication.class, args);
        System.out.println( "HelloApplication Start Success..." );
    }

}
