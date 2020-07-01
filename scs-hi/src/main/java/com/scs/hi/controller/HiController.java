package com.scs.hi.controller;

import com.scs.hi.client.HelloServiceClient;
import com.scs.hi.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author cxf
 * @version 1.0
 * @date 2020-4-11
 */
@RestController
@RequestMapping("/api/v1/hi")
public class HiController {

    @Autowired
    private HiService hiService;
    @Autowired
    private HelloServiceClient helloClient;

    /**
     * sayHi
     * @return
     */
    @GetMapping("/sayHi")
    public String sayHi() {
        return hiService.sayHi();
    }

    /**
     * sayHello
     * @return
     */
    @GetMapping("/sayHello")
    public String sayHello() {
        return helloClient.sayHello();
    }

}
