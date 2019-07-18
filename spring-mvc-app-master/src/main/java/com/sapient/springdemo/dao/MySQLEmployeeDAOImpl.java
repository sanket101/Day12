package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository(value = "mysqlDAOImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public MySQLEmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {
        System.out.println("Came inside the save method of MySQLEmployeeDAOImpl");
        jdbcTemplate.execute("insert into employee(name) values ('"+employee.getName()+"')");
        return employee;
    }

    public List<Employee> listAll() {
       List<Employee> employeeList = jdbcTemplate.query("select * from employee",
               ( rs, rowNum)-> new Employee(rs.getInt(1), rs.getString(2)));
       return employeeList;
    }

    public Employee findById(long id) {
        return jdbcTemplate.queryForObject("select * from Employee where id=" + id,
                (rs, rowNum) -> {
                   Employee employee =  new Employee(rs.getInt(1), rs.getString(2));
                           employee.setAge(45);
                           return employee;
                });

    }

    public void deleteEmployee(long id) {

    }
}