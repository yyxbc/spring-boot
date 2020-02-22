package com.example.demo.client;

import com.example.demo.service.DemoService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Cxfclient {


        public static void main(String[] args) {
            try {

                String address = "http://127.0.0.1:8888/services/TestService?wsdl";

                JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();

                jaxWsProxyFactoryBean.setAddress(address);

                jaxWsProxyFactoryBean.setServiceClass(DemoService.class);

                DemoService us = (DemoService) jaxWsProxyFactoryBean.create();

                String id = "maple";

                String result = us.query(id);
                System.out.println("返回结果:" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

}
