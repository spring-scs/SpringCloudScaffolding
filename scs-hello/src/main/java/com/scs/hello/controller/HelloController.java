package com.scs.hello.controller;

import com.scs.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalTime;

/**
 * @author cxf
 * @version 1.0
 * @date 2020-4-11
 */
@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    /**
     * sayHello
     * @return
     */
    @GetMapping("/sayHello")
    public String sayHello() {
        System.out.println("11111"+ LocalTime.now());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return helloService.sayHello();
    }


}
