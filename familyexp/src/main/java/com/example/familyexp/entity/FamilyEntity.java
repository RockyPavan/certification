package com.example.familyexp.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Entity
@Table(name="family")
public class FamilyEntity {

	@Id
	int fno;
	String fName;
	String dob;
	int phoneno;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FamilyEntity other = (FamilyEntity) obj;
		return fno == other.fno;
	}
	@Override
	public String toString() {
		return "FamilyEntity [fno=" + fno + ", fName=" + fName + ", dob=" + dob + ", phoneno=" + phoneno + "]";
	}
	
	

}
