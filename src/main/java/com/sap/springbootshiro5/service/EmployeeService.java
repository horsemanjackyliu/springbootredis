package com.sap.springbootshiro5.service;

import javax.annotation.PostConstruct;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sap.springbootshiro5.dao.EmployeeRepo;
import com.sap.springbootshiro5.model.Employee;

@Service

public class EmployeeService implements EmployeeRepo{
    private final String  EMPLOYEE_CACHE = "EMPLOYEE";

    @Autowired
    RedisTemplate redisTemplate;

    private HashOperations<String,String,Employee>hashOperations;
    @PostConstruct
    private void initializeHashOperations(){
        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(final Employee employee){
        hashOperations.put(EMPLOYEE_CACHE, employee.getId(), employee);

    }
    @Override
    public Employee findById(final String id){
        return (Employee)hashOperations.get(EMPLOYEE_CACHE, id);
    }
    @Override
    public Map<String,Employee> findAll(){
        return hashOperations.entries(EMPLOYEE_CACHE);
    }
    @Override
    public void delete(String id){
        hashOperations.delete(EMPLOYEE_CACHE, id);
    }

    
}
