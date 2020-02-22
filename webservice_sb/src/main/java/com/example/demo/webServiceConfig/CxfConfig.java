package com.example.demo.webServiceConfig;

import com.example.demo.service.DemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * cxf配置
 */
@Configuration
public class CxfConfig {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return  new SpringBus();
    }

    @Autowired
    private DemoService demoService;

@Bean
    public ServletRegistrationBean dispatcherWebServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoService);
        endpoint.publish("/TestService");
        return endpoint;
    }
}

