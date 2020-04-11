package com.scs.hello.service.impl;

import com.scs.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cxf
 * @version 1.0
 * @date 2020-4-11
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Value("server.port")
    private String serverPort;

    @Override
    public String sayHello() {
        return "Hello,I'm HelloApplication,ServerPort is " + serverPort + ",Now:" + LocalDateTime.now() +";";
    }
}
