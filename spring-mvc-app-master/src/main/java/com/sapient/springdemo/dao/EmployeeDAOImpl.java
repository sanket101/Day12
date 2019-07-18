package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static List<Employee> employees = new ArrayList<Employee>();

    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> listAll() {
        System.out.println("Inside the list all method of EmployeeDAO");

        return null;
    }

    public Employee findById(long id) {
        System.out.println("Inside the findBYId method of EmployeeDAO");
        return null;
    }

    public void deleteEmployee(long id) {
        System.out.println("inside the delete method of EmployeeDAO");
    }
}