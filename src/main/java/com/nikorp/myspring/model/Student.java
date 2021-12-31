package com.nikorp.myspring.model;

import java.util.Arrays;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.nikorp.myspring.validation.CourseCode;

public class Student {

	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	private String lastName;
	private String country;
	private String favLang;
	private String[] opSystems;
	
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	@NotNull(message = "is required")
	private Integer attendance;
	
	@Pattern(regexp = "^[0-9]{6}", message = "only 6 digits")
	private String postalCode;

	@CourseCode
	private String courseCode;
	
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
	public Integer getAttendance() {
		return attendance;
	}
	public void setAttendance(Integer attendance) {
		this.attendance = attendance;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", favLang="
				+ favLang + ", opSystems=" + Arrays.toString(opSystems) + ", attendance=" + attendance + ", postalCode="
				+ postalCode + "]";
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
