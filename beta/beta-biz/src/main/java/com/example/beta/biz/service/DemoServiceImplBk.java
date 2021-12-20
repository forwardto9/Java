package com.example.beta.biz.service;

import com.example.beta.biz.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImplBk implements DemoService {
    @Override
    public String test() {
        return "BK service";
    }
}
