package com.lokesh.hospital.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lokesh.hospital.models.Hospital;
import com.lokesh.hospital.repo.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> getHospitals(){
		return hospitalRepository.findAll();
	}
	
	public Hospital getHospital(int id) {
		/*
		 * The method findById() is present in the newer version the CrudRepository. It's equivalent was the findOne() method.
		 * But findById() returns an Optional whereas findOne() would have returned the Hospital object directly.
		 */
		return hospitalRepository.findById(id).orElse(null);
	}
	
	public Hospital updateHospital(Hospital hospital) {
		Optional<Hospital> foundHospital = hospitalRepository.findById(hospital.getId());
		if(foundHospital.isPresent()) {			
			return hospitalRepository.save(hospital);
		}else {
			return null;
		}
	}
	
	public void addHospital(Hospital hospital) {		
		hospitalRepository.save(hospital);		
	}
}
