package com.example.familyexp.dto;


import org.springframework.boot.autoconfigure.SpringBootApplication;


public class FamilyDTO {

	int familyno;
	String Name;
	String dob;
	int phoneno;
	public int getFamilyno() {
		return familyno;
	}
	public void setFamilyno(int familyno) {
		this.familyno = familyno;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public String toString() {
		return "FamilyDTO [familyno=" + familyno + ", Name=" + Name + ", dob=" + dob + ", phoneno=" + phoneno + "]";
	}

}
