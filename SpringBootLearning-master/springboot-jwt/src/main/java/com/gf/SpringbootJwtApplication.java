package com.gf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.gf.Mapper")
@SpringBootApplication
public class SpringbootJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run( SpringbootJwtApplication.class, args );
    }

}
