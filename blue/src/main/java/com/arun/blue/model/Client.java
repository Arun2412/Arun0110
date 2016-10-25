package com.arun.blue.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Component
public class Client implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public MultipartFile getPic() {
		return pic;
	}
	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int clientid;
	@NotEmpty(message="Email Id Field Should not be empty")
	private String emailid;
	@NotEmpty(message="Password Field Should not be empty")
	private String password;
	@NotEmpty(message="Name Field Should not be empty")
	private String name;
	@NotEmpty(message="Address Field Should not be empty")
	private String address;
	@NotEmpty(message="Date Of Birth Field Should not be empty")
	private String dob;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private boolean enabled;
	@Transient
	private MultipartFile pic;
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
