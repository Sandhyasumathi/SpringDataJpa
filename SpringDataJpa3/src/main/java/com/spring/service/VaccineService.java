package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;

import com.spring.entity.Vaccine;
import com.spring.view.View;

public interface VaccineService {
	
//	public Vaccine registerVaccine(Vaccine vaccine);
//	public ArrayList<Vaccine> bulkRegisterVaccine(ArrayList<Vaccine> vaccines);
//	public Long countOfVaccines();
//	public boolean vaccineAvailability(int id);
	
	public<T extends View> List<T> searchByletter(char c,Class<T> cls);

}
