package com.sap.springbootshiro5.controll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sap.springbootshiro5.model.Employee;
import com.sap.springbootshiro5.service.EmployeeService;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/redis/employee")
public class EmployeeController {
    
   private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    EmployeeService employeeService;

    
    @PostMapping
public String save(@RequestBody final Employee employee){
    log.info("save employee to redis");
    employeeService.save(employee);
    return "Success created employee with id" + employee.getId();
}


@GetMapping(value = "/all")
public Map<String, Employee> getAll(){
    log.info("Get All Employee");
    return employeeService.findAll();
}
@DeleteMapping(path = "/delete/{id}")
public Map<String,Employee> delete(@PathVariable("id") String id){
    log.info("delete employee ");
    employeeService.delete(id);
    return getAll();
}
@GetMapping(path = "/{id}")
public Employee getById(@PathVariable("id") String id){
    log.info("find employee with id" + id);
    return employeeService.findById(id);
}
    
}
