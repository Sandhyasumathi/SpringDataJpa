package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.spring.entity.Vaccine;

public interface VaccineService {
	
//	public Vaccine registerVaccine(Vaccine vaccine);
//	public ArrayList<Vaccine> bulkRegisterVaccine(ArrayList<Vaccine> vaccines);
//	public Long countOfVaccines();
//	public boolean vaccineAvailability(int id);
	
	public Iterable<Vaccine> fetchAndSortDetails(boolean status, String... Properties);
	
	public List<Vaccine> fetchAndPagenation(int pageNo, int pageSize,boolean status, String... Properties);

}
