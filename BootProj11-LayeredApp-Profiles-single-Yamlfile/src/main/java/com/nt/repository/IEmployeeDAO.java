package com.nt.repository;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {

	public List<Employee> getAllEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception;
}
