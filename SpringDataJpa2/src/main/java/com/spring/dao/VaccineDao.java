package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Vaccine;

@Repository
public interface VaccineDao extends JpaRepository<Vaccine, Integer> {

}
