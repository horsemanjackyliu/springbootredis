package com.sap.springbootshiro5.dao;

import com.sap.springbootshiro5.model.Employee;
import java.util.Map;

public interface EmployeeRepo {
    void save(Employee employee);
    Employee findById(String id);
    Map<String,Employee>findAll();
    void delete(String id);

    
}
