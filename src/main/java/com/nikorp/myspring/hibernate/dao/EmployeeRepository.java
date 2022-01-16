package com.nikorp.myspring.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikorp.myspring.hibernate.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
