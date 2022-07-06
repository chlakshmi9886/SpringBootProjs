package com.nt.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("oraEmpDAO")
@Profile({"prod","uat"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPL_BY_DESG = " SELECT EMPNO, EMPNAME, DESG, SAL, DEPTNO FROM EMP WHERE DESG IN (?,?,?) ORDER BY DESG";

	@Autowired
	private DataSource ds;
	
	
	
	public OracleEmployeeDAOImpl() {
		System.out.println("OracleEmployeeDAOImpl.OracleEmployeeDAOImpl()");
	}



	@Override
	public List<Employee> getAllEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception
	{
		
		System.out.println("EmployeeDAOImpl.getAllEmployeesByDesg() :: " +ds.getClass());

		List<Employee> list = null;
		try(Connection con = ds.getConnection()){
	
			PreparedStatement ps = con.prepareStatement(GET_EMPL_BY_DESG);
			
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			try(ResultSet rs = ps.executeQuery()){
				list = new ArrayList<Employee>();
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setEmpid(rs.getInt(1));
					emp.setEmpname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSal(rs.getLong(4));
					emp.setDeptid(rs.getInt(5));
					list.add(emp);
				}//while
			}//try
		}//outside try
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return list;
	}
}
