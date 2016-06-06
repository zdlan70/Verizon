package com.verzion.assignment.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    private double salary;
    

    @OneToOne
    @JoinColumn(name="managerId", referencedColumnName="id", nullable=true)
    private Employee manager;
    
    @OneToOne
    @JoinColumn(name="departmentId", referencedColumnName="id")
    private Department department;
    
    protected Employee() {}

    public Employee(String firstName, String lastName, double salary,  Department department, Employee manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.manager = manager;
        
    }
    
    


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
    public String toString() {
        return String.format(
                "Employee[id=%d, firstName='%s', lastName='%s',salaray='%s',  department='%s', manager='%s']",
                id, firstName, lastName, salary, toString(department), toString(manager));
    }

    private static String toString(Object obj) {
    	return obj==null? "": obj.toString();
    	
    }
}

