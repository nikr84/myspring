package com.nikorp.myspring.hibernate.dao;

import java.util.List;

import com.nikorp.myspring.hibernate.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
