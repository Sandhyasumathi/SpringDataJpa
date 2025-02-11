package com.springjdbc.SpringJdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springjdbc.SpringJdbc.model.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao{
	
	@Autowired
	private DataSource dataSource;
	private Connection connect;
	private PreparedStatement pstmt;
	private String sql = "SELECT * FROM EMPLOYEE";
	List<Employee> employees;

	@Override
	public List<Employee> getEmployeeDetails() {
		
		try {
			connect = dataSource.getConnection();
			pstmt = connect.prepareStatement(sql);
		    ResultSet rs = pstmt.executeQuery();
		    employees = new ArrayList<>();
		    while(rs.next()) {
		    	Employee emp = new Employee();
		    	
		    	emp.setId(rs.getInt(1));
		    	emp.setName(rs.getString(2));
		    	emp.setCity(rs.getString(3));
		    	
		    	employees.add(emp);
		    }
		}catch(Exception e) {
			
		}
		return employees;
	}

}
