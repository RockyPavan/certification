package com.example.familyException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


public class FamilyException extends Exception{
	private static final long serialVersionUID = 1L;
	
public FamilyException(String message){
	super(message);
	
}
	

}
