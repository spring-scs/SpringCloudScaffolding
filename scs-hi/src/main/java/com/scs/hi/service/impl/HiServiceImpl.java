package com.scs.hi.service.impl;

import com.scs.hi.service.HiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author cxf
 * @version 1.0
 * @date 2020-4-11
 */
@Service
public class HiServiceImpl implements HiService {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String sayHi() {
        return "Hi,I'm HiApplication,ServerPort is " + serverPort + ",Now:" + LocalDateTime.now() +";";
    }
}
