package com.xwzj.scs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurakaApplication {
    
	public static void main( String[] args ){
//        new SpringApplicationBuilder(EurakaApplication.class).web(WebApplicationType.SERVLET).run(args);
        SpringApplication.run(EurakaApplication.class, args);
        log.info( "Euraka Start Success..." );
    }

}
