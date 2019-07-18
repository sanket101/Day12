package com.sapient.springdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Employee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private  long id;

    @NotEmpty
    @XmlElement(name = "NAME")
    @Column(name="emp_name")
    private  String name;
    @NotNull
    @Range(min = 18, max = 58, message = "Age should be between 18 and 58")
    @XmlElement
    @Column(name="emp_age")
    private  int age;

    @NotNull
    @Range(min =20000, max = 50000, message = "Salary should be between 20000 and 50000")
    @XmlElement
    @Column(name="emp_salary")
    private double salary;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="employee_id")
    @XmlElement
    private List<Dependent> dependents;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    public Employee(){

    }

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}