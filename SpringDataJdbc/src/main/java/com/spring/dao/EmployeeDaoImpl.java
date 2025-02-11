package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
	
	@Autowired
	private JdbcTemplate temp;
	private String sql="insert into employee values(3,'Name3','City3');";
	
	public void addemployee() {
		temp.update(sql);
	}

	@Override
	public List<Employee> getEmployeeDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
