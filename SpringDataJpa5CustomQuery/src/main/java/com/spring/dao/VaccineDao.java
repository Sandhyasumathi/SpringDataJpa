package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Vaccine;

@Repository
public interface VaccineDao extends JpaRepository<Vaccine, Integer> 

{

	List<Vaccine> findByvCompanyStartingWith(char c);
	
//	@Query("From Vaccine where vCompany=:name")
//	List<Vaccine> searchByVCompany(String name);
	
	@Query("From Vaccine where vCompany=:name")
	List<Vaccine> searchByVCompany(@Param("name") String companyName);
	
	@Query("From Vaccine where vCompany In (:company1,:company2)")
	List<Vaccine> searchBy2Param(String company1, String company2);
	
	@Transactional
	@Modifying
	@Query("UPDATE Vaccine SET vCompany=:Company WHERE name=:name")
	public int updateByVaccineName(String name,String Company);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Vaccine WHERE name=:name")
	public int deleteByVaccineName(String name);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO Vaccine(`id`,`name`,`v_company`) VALUES(?,?,?)", nativeQuery = true)
	public int insertInto(int id,String name,String vCompany);
}
