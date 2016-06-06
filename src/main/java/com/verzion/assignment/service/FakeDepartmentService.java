package com.verzion.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verzion.assignment.db.Department;
import com.verzion.assignment.db.DepartmentRepository;


@Service
public class FakeDepartmentService implements DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override    
	public List<Department> findByName(String name)  {
		
		return departmentRepository.findByName(name);
	}

	@Override
	public List<Department> findById(Long id) {		
		return departmentRepository.findById(id);
	}

	@Override
	public void save(Department department) {
		departmentRepository.save(department);
		
	}

	@Override
	public Department findOne(long l) {
		// TODO Auto-generated method stub
		return departmentRepository.findOne(l);
	}
	
}
