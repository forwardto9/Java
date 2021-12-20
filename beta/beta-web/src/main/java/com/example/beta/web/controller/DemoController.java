package com.example.beta.web.controller;

import com.example.beta.biz.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Qualifier("demoServiceImpl")
    @Autowired
    private DemoService demoService;
    @GetMapping("test")
    public String test() {
        return demoService.test();
    }
}
