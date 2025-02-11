package com.springjdbc.SpringJdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springjdbc.SpringJdbc.dao.EmployeeDao;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringJdbcApplication.class, args);
	
		EmployeeDao employee = container.getBean(EmployeeDao.class);
		
		employee.getEmployeeDetails().forEach(System.out::println);
	}

}
