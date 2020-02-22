package com.example.demo.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class Cxfclient {


        public static void main(String[] args) throws Exception {
            main1();
        }

        /**
         * 1.代理类工厂的方式,需要拿到对方的接口地址
         */
        public static void main1() throws Exception {
//            try {
//                // 接口地址
//                String address = "http://127.0.0.1:8888/services/TestService?wsdl";
//                // 代理工厂
//                JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//                // 设置代理地址
//                jaxWsProxyFactoryBean.setAddress(address);
//                // 设置接口类型
//                jaxWsProxyFactoryBean.setServiceClass(DemoService.class);
//                // 创建一个代理接口实现
//                DemoService us = (DemoService) jaxWsProxyFactoryBean.create();
//                // 数据准备
//                String id = "111";
//                // 调用代理接口的方法调用并返回结果
//                String result = us.query(id);
//                System.out.println("返回结果:" + result);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
            Client client = clientFactory.createClient("http://127.0.0.1:8888/services/TestService?wsdl");
            Object[] result = client.invoke("query", "123");
            System.out.println(result[0]);
        }
}
