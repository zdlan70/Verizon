package com.verzion.assignment.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;

    private double salary_min_range;
    private double salary_max_range;
    
    protected Department() {}

    public Department(String lastName, double salary_min_range, double salary_max_range) {
        this.name = lastName;
        this.salary_max_range = salary_max_range;
        this.salary_min_range = salary_min_range;
        
    }

    @Override
    public String toString() {
        return String.format(
                "Department[id=%d, name='%s', salaray_min_range='%s', salary_max_range='%s']",
                id, name, salary_min_range, salary_max_range);
    }

}

