package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.dao.VaccineDao;
import com.spring.entity.Vaccine;

@Service
public class VaccineServiceImpl implements VaccineService {
	
	@Autowired
	private VaccineDao vaccineDao;

	@Override
	public Iterable<Vaccine> fetchAndSortDetails(boolean status, String... Properties) {
		Sort sort = Sort.by(true?Direction.ASC:Direction.DESC, "name","vCompany");
		return vaccineDao.findAll(sort);
	}

	@Override
	public List<Vaccine> fetchAndPagenation(int pageNo, int pageSize, boolean status, String... Properties) {
		
		PageRequest pageable = PageRequest.of(pageNo, pageSize, true?Direction.ASC:Direction.DESC, "name","vCompany");
		Page<Vaccine> page = vaccineDao.findAll(pageable);
		
		return page.getContent();
	}



//	@Override
//	public Vaccine registerVaccine(Vaccine vaccine) {
//		
//		return vaccineDao.save(vaccine);
//	}
//
//	@Override
//	public ArrayList<Vaccine> bulkRegisterVaccine(ArrayList<Vaccine> vaccines) {
//		
//		return (ArrayList<Vaccine>) vaccineDao.saveAll(vaccines);
//	}
//
//	@Override
//	public Long countOfVaccines() {
//		
//		return vaccineDao.count();
//	}
//
//	@Override
//	public boolean vaccineAvailability(int id) {
//	
//		return vaccineDao.existsById(id);
//	}
//	
//	public Vaccine findById(int id) {
//		return vaccineDao.findById(id).get();
//	}

}
