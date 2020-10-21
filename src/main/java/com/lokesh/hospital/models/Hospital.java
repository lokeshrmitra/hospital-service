package com.lokesh.hospital.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private float rating;
	
	
	
	public Hospital() {
		super();
	}

	public Hospital(int id, String name, float rating) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
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
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
}
