package com.spring;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.spring.entity.Vaccine;
import com.spring.service.VaccineServiceImpl;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpa1Application.class, args);

//		Vaccine v = new Vaccine( "Vaccine2", "Vcompany2");

		VaccineServiceImpl vs = container.getBean(VaccineServiceImpl.class);

//		vs.registerVaccine(v);
		
//		System.out.println(vs.findById(52));
//		System.out.println("Before" + vs.countOfVaccines());
//		ArrayList<Vaccine> al = new ArrayList<>();
//		al.add(new Vaccine( "DVaccine4", "Vcompany4"));
//		al.add(new Vaccine( "AVaccine5", "Vcompany2"));
//		al.add(new Vaccine( "BVaccine6", "Vcompany2"));
//		al.add(new Vaccine( "EVaccine7", "Vcompany2"));
//		al.add(new Vaccine( "CVaccine8", "Vcompany2"));
//		
//		System.out.println(vs.bulkRegisterVaccine(al));
//		System.out.println("After" + vs.countOfVaccines());
		
		
		vs.fetchAndSortDetails(true, "name","vCompany").forEach(e->System.out.println(e));
		
		vs.fetchAndPagenation(1, 2, true, "name","vCompany").forEach(e->System.out.println(e));
	}

}
