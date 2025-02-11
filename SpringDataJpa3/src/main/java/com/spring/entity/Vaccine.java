package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String vCompany;
	public Vaccine( String name, String vCompany) {
		super();
		
		this.name = name;
		this.vCompany = vCompany;
	}
	public Vaccine() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getvCompany() {
		return vCompany;
	}
	public void setvCompany(String vCompany) {
		this.vCompany = vCompany;
	}
	@Override
	public String toString() {
		return "Vaccine [id=" + id + ", name=" + name + ", vCompany=" + vCompany + "]";
	}
	
	
}
