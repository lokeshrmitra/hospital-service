package com.lokesh.hospital.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.hospital.models.Hospital;
import com.lokesh.hospital.service.HospitalService;

@RestController
@RequestMapping("/test/hospitals")
public class HospitalServiceController {
	
	@Autowired
	private HospitalService hospitalService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Hospital> getHospitals() {
		return hospitalService.getHospitals();
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)	
	public ResponseEntity<Hospital> getHospital(@PathVariable("id") int id) {
		Hospital hosp = hospitalService.getHospital(id);
		if(hosp != null)
			return new ResponseEntity<Hospital>(hosp, HttpStatus.OK);
		else 
			return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method first searches the hospital with the provided id, if a hospital with that id is found it will update it with the other parameters,
	 * otherwise return null
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Hospital> updateHospital(
			@Param(value = "id") int id,
			@Param(value = "name") String name,
			@Param(value = "rating") float rating
			) {
		return new ResponseEntity<Hospital>(hospitalService.updateHospital(new Hospital(id, name, rating)), HttpStatus.OK); 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addHospital(
			@Param(value = "id") int id,
			@Param(value = "name") String name,
			@Param(value = "rating") float rating
			) {
		hospitalService.addHospital(new Hospital(id, name, rating));
		return "Hospital Added";
	}
}
