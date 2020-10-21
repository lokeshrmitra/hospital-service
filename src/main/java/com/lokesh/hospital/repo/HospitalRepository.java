package com.lokesh.hospital.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lokesh.hospital.models.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Integer> {
	List<Hospital> findAll();
}
