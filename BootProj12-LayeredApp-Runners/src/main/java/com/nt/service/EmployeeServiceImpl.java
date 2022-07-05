package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeDAO;

@Service("emplService")
public class EmployeeServiceImpl implements IEmployeeService {

	public EmployeeServiceImpl() {
		System.out.println("EmployeeServiceImpl.EmployeeServiceImpl()");
	}
	@Autowired
	private IEmployeeDAO emplDao;
	@Override
	public List<Employee> fetchEmployeeByDesignations(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> emplList = emplDao.getAllEmployeesByDesg(desg1, desg2, desg3);
		return emplList;
	}

}
