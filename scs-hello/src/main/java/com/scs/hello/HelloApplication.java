package com.scs.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class HelloApplication {

    @Value("${spring.datasource.url}")
    String url;

	public static void main( String[] args ){
        SpringApplication.run(HelloApplication.class, args);
        System.out.println( "HelloApplication Start Success..." );
    }

    @RequestMapping("/get")
    public String getName(){
        return url;
    }
}
