package com.example.demo.service;

import javax.jws.WebService;

@WebService(
        name = "DemoService", // 暴露服务名称
        targetNamespace = "http://service.demo.example.com"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {
    public String query(String name);
}
