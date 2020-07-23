package com.scs.euraka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import zipkin.storage.mysql.MySQLStorage;
import zipkin2.server.internal.EnableZipkinServer;

import javax.sql.DataSource;


@Slf4j
@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
@ComponentScan("zipkin2")
public class ZipkinServerApplication {

    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }

	public static void main( String[] args ){
        SpringApplication.run(ZipkinServerApplication.class, args);
        log.info( "ZipkinServer Start Success..." );
    }

}
