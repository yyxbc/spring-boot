package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    //手动将RestTemplate加入Spring容器中
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/getUser.json")
    @ResponseBody
    public String getUser() {
        String url = "http://localhost:8000/hello/getall";
        String forObject = restTemplate.getForObject(url, String.class);
        return forObject;
    }

    @RequestMapping("/postUser.json")
    @ResponseBody
    public String postUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType (MediaType.APPLICATION_JSON);
        String url = "http://localhost:8000/hello/getall";
        HttpEntity entityparam = new HttpEntity(headers);
        String forObject = restTemplate.postForObject(url, entityparam, String.class);
        return forObject;
    }
}
