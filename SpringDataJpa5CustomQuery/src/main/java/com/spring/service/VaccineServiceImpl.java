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
	public Vaccine searchById(int id) {
		
		return vaccineDao.getReferenceById(id);
	}

	@Override
	public List<Vaccine> filterByCompanyNameStartswith(char c) {
		// TODO Auto-generated method stub
		return vaccineDao.findByvCompanyStartingWith(c);
	}

	@Override
	public List<Vaccine> fetchByCompany(String name) {
		// TODO Auto-generated method stub
		return vaccineDao.searchByVCompany(name);
	}

	@Override
	public List<Vaccine> fetchByCompany(String company1, String company2) {
		// TODO Auto-generated method stub
		return vaccineDao.searchBy2Param(company1, company2);
	}

	@Override
	public int update(String name, String vCompany) {
		
		return vaccineDao.updateByVaccineName(name, vCompany);
	}

	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		return vaccineDao.deleteByVaccineName(name);
	}

	@Override
	public int insert(int id, String name, String vCompany) {
		// TODO Auto-generated method stub
		return vaccineDao.insertInto(id, name, vCompany);
	}

//	@Override
//	public Iterable<Vaccine> fetchAndSortDetails(boolean status, String... Properties) {
//		Sort sort = Sort.by(true?Direction.ASC:Direction.DESC, "name","vCompany");
//		return vaccineDao.findAll(sort);
//	}
//
//	@Override
//	public List<Vaccine> fetchAndPagenation(int pageNo, int pageSize, boolean status, String... Properties) {
//		
//		PageRequest pageable = PageRequest.of(pageNo, pageSize, true?Direction.ASC:Direction.DESC, "name","vCompany");
//		Page<Vaccine> page = vaccineDao.findAll(pageable);
//		
//		return page.getContent();
//	}



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
