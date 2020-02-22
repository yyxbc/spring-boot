package com.example.demo.sevice;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(key = "#p0")
    public Employee getEmp(Integer id){
        System.out.println("search");
        return employeeMapper.getEmpById(id);
    }
    @CachePut(key = "#p0.id")
    public Employee insrt(Employee employee){
        employeeMapper.insertEmployee(employee);
        return getEmp(employee.getId());
    }
    @CachePut(key = "#p0.id")
    public Employee update(Employee employee){
        System.out.println("update"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
    @CacheEvict(key = "#p0")
    public void deleteEmpById(Integer id){
        System.out.println("delete"+id);
    }
}
