package com.nikorp.myspring.model;

import java.util.Arrays;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favLang;
	private String[] opSystems;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFavLang() {
		return favLang;
	}
	public void setFavLang(String favLang) {
		this.favLang = favLang;
	}
	public String[] getOpSystems() {
		return opSystems;
	}
	public void setOpSystems(String[] opSystems) {
		this.opSystems = opSystems;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", favLang="
				+ favLang + ", opSystems=" + Arrays.toString(opSystems) + "]";
	}

}
