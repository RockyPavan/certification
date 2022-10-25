package com.example.familyexp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.familyException.FamilyException;
import com.example.familyexp.dto.FamilyDTO;
import com.example.familyexp.entity.FamilyEntity;
import com.example.familyexp.repositary.FamilyRepositary;

@Service
public class FamilyService {
	
	@Autowired
	FamilyRepositary familyRepo;

	public List<FamilyDTO> getAll() throws FamilyException {
		Iterable<FamilyEntity>familydtos=familyRepo.findAll();
		List<FamilyDTO>familydto=new LinkedList<>();
		for (FamilyEntity familys : familydtos) {
			FamilyDTO family=new FamilyDTO();
			family.setFamilyno(familys.getFno());
			family.setName(familys.getfName());
			family.setDob(familys.getDob());
			family.setPhoneno(familys.getPhoneno());
			familydto.add(family);		
		}
		if(familydto.isEmpty()) {
			throw new FamilyException("all.notfound");
		}
		// TODO Auto-generated method stub
		return familydto;
	}

	public FamilyEntity getbyId(int id) throws FamilyException {
		Optional<FamilyEntity>optional=familyRepo.findById(id);
		FamilyEntity family=optional.orElseThrow(()-> new FamilyException("ID.notfound"));
		// TODO Auto-generated method stub
		return family;
	}

	public String updateById(FamilyEntity familyEntity) throws FamilyException {
		Optional<FamilyEntity>optional=familyRepo.findById(familyEntity.getFno());
		FamilyEntity family=optional.orElseThrow(()->new FamilyException("ID.notfound"));
		//FamilyEntity family2=new FamilyEntity();
		family.setFno(familyEntity.getFno());
		family.setfName(familyEntity.getfName());
		family.setDob(familyEntity.getDob());
		family.setPhoneno(familyEntity.getPhoneno());
		familyRepo.save(family);
		// TODO Auto-generated method stub
		return "sucess";
	}

	public String createNew(FamilyEntity familyEntity) throws FamilyException {
		Optional<FamilyEntity>optional=familyRepo.findById(familyEntity.getFno());
		if(optional.isPresent()) {
			throw new FamilyException("ID.exist");
		}
		String no=String.valueOf(familyEntity.getPhoneno());
		if(no.length()>6) {
			throw new FamilyException("ID.length");
		}
		FamilyEntity family=new FamilyEntity();
		family.setFno(familyEntity.getFno());
		family.setDob(familyEntity.getDob());
		family.setfName(familyEntity.getfName());
		family.setPhoneno(familyEntity.getPhoneno());
		familyRepo.save(family);
		// TODO Auto-generated method stub
		return "sucess";
	}

	public String delete(int id) throws FamilyException {
		Optional<FamilyEntity>optional=familyRepo.findById(id);
		FamilyEntity family=optional.orElseThrow(()->new FamilyException("ID.notfound"));
		familyRepo.deleteById(id);
		// TODO Auto-generated method stub
		return "sucess deleted";
	}

	

}
