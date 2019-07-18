package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hibernateDAOImpl")
public class HibernateEmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
        return employee;
    }

    @Override
    public List<Employee> listAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("from Employee ").list();
    }

    @Override
    public Employee findById(long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(long id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.byId(Employee.class).load(id);
        session.delete(employee);
    }
}