package com.scs.hello.service.impl;

import com.scs.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cxf
 * @version 1.0
 * @date 2020-4-11
 */
@Service
@RefreshScope
public class HelloServiceImpl implements HelloService {

    @Value("${server.port}")
    private String serverPort;

    @Value("${from.val}")
    private String fromVal;

    @Override
    public String sayHello() {
        return "Hello,I'm HelloApplication,I am from "+fromVal+",ServerPort is " + serverPort + ",Now:" + LocalDateTime.now() +";";
    }
}
