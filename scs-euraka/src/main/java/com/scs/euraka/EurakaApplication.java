package com.scs.euraka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurakaApplication {

	public static void main( String[] args ){
        SpringApplication.run(EurakaApplication.class, args);
        log.info( "Euraka Start Success..." );
    }

}
