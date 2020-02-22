package com.example.demo.controller;

import com.example.demo.bean.Employee;
import com.example.demo.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
    Employee employee = employeeService.getEmp(id);
//    redisTemplate.opsForValue().set("emp"+id,employee);
    return employee;
    }
    @GetMapping("/emp" )
    public Employee update(Employee emp){
       Employee employee= employeeService.update(emp);
        return  employee;
    }

    @GetMapping("/delemp" )
    public String deleteemp(Integer id){
       employeeService.deleteEmpById(id);
        return  "success";
    }
    @GetMapping("/test/{id}")
    public void test1(@PathVariable("id") Integer id) {
        stringRedisTemplate.opsForValue().append("msg","hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        Object msg2 = redisTemplate.opsForValue().get("emp"+id);
        System.out.println(msg2);
        System.out.println(123);
    }


}
