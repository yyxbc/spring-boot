package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DemoApplicationTests {

    @Test
   public  void contextLoads() {
//        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
//        proxyFactoryBean.setAddress("http://localhost:8080/services/hello?wsdl");
//        proxyFactoryBean.setServiceClass(DemoService.class);
//        DemoService demoService = (DemoService)proxyFactoryBean.create();
//        String query=demoService.query("nann");
        System.out.println(1);
    }

}
