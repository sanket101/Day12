package com.sapient.springdemo.service;

import com.sapient.springdemo.dao.EmployeeDAO;
import com.sapient.springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired( required = true)
    @Qualifier(value = "hibernateDAOImpl")
    private EmployeeDAO employeeDAO;


    public EmployeeServiceImpl(@Qualifier(value = "mysqlDAOImpl")EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        System.out.println("Inside the save employee method of Employee service class ....");
        return employeeDAO.save(employee);
    }

    @Transactional
    public List<Employee> fetchAllEmployees() {
        return employeeDAO.listAll();
    }

    @Transactional
    public Employee findById(long id) {
        return employeeDAO.findById(id);
    }

    @Transactional
    public void deleteEmployee(long id) {
        employeeDAO.deleteEmployee(id);
    }
}