package com.raketlabs.postgresql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="adminuser")
public class AdminUser {
	
	@Id
	@Column(name="adminuser_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminuser_id;

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
	@NotEmpty
	private int activity;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(name="role", joinColumns = @JoinColumn(name="adminuser_id"), inverseJoinColumns = @JoinColumn(name="id"))
//	private Set<AdminRole> roles;
	
	//setter and getter

	public long getAdminuser_id() {
		return adminuser_id;
	}

	public void setAdminuser_id(long adminuser_id) {
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

	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
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
