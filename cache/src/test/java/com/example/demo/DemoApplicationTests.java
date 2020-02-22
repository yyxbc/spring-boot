package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {
    //@Autowired
    //EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        //Employee e = employeeMapper.getEmpById(1);
        //System.out.println(e);
    }

    @Test
    public void test1() {
    stringRedisTemplate.opsForValue().append("msg","hello");
    String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
        System.out.println(123);
    }
}
