package br.com.senai.sp.informatica.tecnow.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.DigestUtils;

import br.com.senai.sp.informatica.tecnow.utils.Gender;

public class User {

	// Props
	private Long id;
	private String name;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private Gender gender;
	
	/**
	 * This method encrypt the user password
	 */
	public void hashPassword() {
		try {
			this.password = DigestUtils.md5DigestAsHex(this.password.getBytes("UTF-8"));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", birthDate="
				+ birthDate + ", gender=" + gender + "]";
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
