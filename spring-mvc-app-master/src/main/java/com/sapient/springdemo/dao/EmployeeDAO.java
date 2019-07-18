package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import java.util.List;

public interface EmployeeDAO {

    public Employee save(Employee employee);

    public List<Employee> listAll();

    public Employee findById(long id);

    public void deleteEmployee(long id);

}