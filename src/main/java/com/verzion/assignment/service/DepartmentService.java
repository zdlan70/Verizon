package com.verzion.assignment.service;

import java.util.List;

import com.verzion.assignment.db.Department;

public interface DepartmentService {
	List<Department> findByName(String name);
    List<Department> findById(Long id);
	void save(Department department);
	Department findOne(long l);
}
