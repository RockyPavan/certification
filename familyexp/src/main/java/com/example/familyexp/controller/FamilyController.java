package com.example.familyexp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.familyException.FamilyException;
import com.example.familyexp.dto.FamilyDTO;
import com.example.familyexp.entity.FamilyEntity;
import com.example.familyexp.service.FamilyService;

@RestController
public class FamilyController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	FamilyService familyService;
	
	
	@RequestMapping(value="/family",method=RequestMethod.GET)
	public ResponseEntity<List<FamilyDTO>> getall()throws FamilyException{
		try {
		List<FamilyDTO>familydtos=familyService.getAll();
		return new ResponseEntity<>(familydtos,HttpStatus.OK);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);	
	}
		
	}
	@RequestMapping(value="/family/{id}",method=RequestMethod.GET)
	public ResponseEntity<FamilyDTO> getById(@PathVariable int id){
		try {
			FamilyEntity family=familyService.getbyId(id);
			
			FamilyDTO familydto=new FamilyDTO();
			familydto.setFamilyno(family.getFno());
			familydto.setName(family.getfName());
			familydto.setDob(family.getDob());
			familydto.setPhoneno(family.getPhoneno());
			
			return new ResponseEntity<>(familydto,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
		
	}
	
	@RequestMapping(value="/family",method=RequestMethod.PUT)
	public ResponseEntity<String> updateById(@RequestBody FamilyEntity familyEntity)throws FamilyException{
		try {
			String mssg=familyService.updateById(familyEntity);
			return new ResponseEntity<String>(mssg, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
		
	}
	
	@RequestMapping(value="/family",method=RequestMethod.POST)
	public ResponseEntity<String> createNew(@RequestBody FamilyEntity familyEntity)throws FamilyException{
		try {
			String mssg=familyService.createNew(familyEntity);
			return new ResponseEntity<>(mssg,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
		
	}
	
	//@RequestMapping(value="/family/{id}",method = RequestMethod.DELETE)
	@DeleteMapping(value="/family/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)throws FamilyException{
		try {
			String mssg=familyService.delete(id);
			return new ResponseEntity<String>(mssg,HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
		}
		
	}

	
}
