package com.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Vaccine;
import com.spring.view.View;

@Repository
public interface VaccineDao extends JpaRepository<Vaccine, Integer> {

	public<T extends View> List<T> findByNameStartingWith(char c,Class<T> cls);
}
