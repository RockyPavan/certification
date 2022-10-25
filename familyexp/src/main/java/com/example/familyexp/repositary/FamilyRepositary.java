package com.example.familyexp.repositary;

import org.springframework.data.repository.CrudRepository;

import com.example.familyexp.entity.FamilyEntity;

public interface FamilyRepositary extends CrudRepository<FamilyEntity,Integer>{

}
