package com.example.demo.service.impl;

import com.example.demo.service.DemoService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(
        serviceName = "DemoService",
        targetNamespace = "http://service.demo.example.com",
        endpointInterface = "com.example.demo.service.DemoService"
)
@Component
public class DemoServiceImpl implements DemoService {
    @Override
    public String query(String name) {

        final String xml = "调用成功"+name;
        return xml;

    }
}
