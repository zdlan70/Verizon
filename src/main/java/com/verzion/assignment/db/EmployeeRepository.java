package com.verzion.assignment.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByLastName(String lastName);
    List<Employee> findById(Long id);
}
