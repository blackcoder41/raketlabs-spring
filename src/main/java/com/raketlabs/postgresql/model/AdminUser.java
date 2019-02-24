package com.raketlabs.postgresql.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="adminuser")
public class AdminUser extends AuditModel {
	
	@Id
	@Column(name="adminuser_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger adminuser_id;

	@Column(name="username")
	@NotEmpty
	private String username;
	
	@Column(name="password")
	@NotEmpty
	private String password;
	
	@Column(name="firstname")
	@NotEmpty
	private String firstname;
	
	@Column(name="lastname")
	@NotEmpty
	private String lastname;
	
	@Column(name="email")
	@NotEmpty
	private String email;
	
	@Column(name="mobile_no")
	@NotEmpty
	private String mobile_no;
	
	@Column(name="activity")
	@NotNull
	private Integer activity;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="role", joinColumns = @JoinColumn(name="adminuser_id"), inverseJoinColumns = @JoinColumn(name="id"))
//	private Set<AdminRole> roles;
	
	@Override
	public String toString() {
		return username + " : " + email + " | " + getCreatedAt() + " | " + getUpdatedAt();
	}
	
	//setter and getter

	public BigInteger getAdminuser_id() {
		return adminuser_id;
	}

	public void setAdminuser_id(BigInteger adminuser_id) {
		this.adminuser_id = adminuser_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public Integer getActivity() {
		return activity;
	}

	public void setActivity(Integer activity) {
		this.activity = activity;
	}

//	public Set<AdminRole> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<AdminRole> roles) {
//		this.roles = roles;
//	}
}
