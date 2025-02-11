package com.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Vaccine;

@Repository
public interface VaccineDao extends PagingAndSortingRepository<Vaccine, Integer> {

}
