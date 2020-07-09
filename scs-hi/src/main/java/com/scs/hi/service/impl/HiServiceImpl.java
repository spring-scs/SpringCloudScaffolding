package com.scs.hi.service.impl;

import com.scs.hi.service.HiService;
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
public class HiServiceImpl implements HiService {

    @Value("${server.port}")
    private String serverPort;
    @Value("${from.val}")
    private String fromVal;

    @Override
    public String sayHi() {
        return "Hi,I'm HiApplication,I am from "+fromVal+",ServerPort is " + serverPort + ",Now:" + LocalDateTime.now() +";";
    }
}
