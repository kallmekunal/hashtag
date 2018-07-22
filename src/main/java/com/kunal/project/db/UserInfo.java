package com.kunal.project.db;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Kunal
 *
 */
@Entity
@Table(name="user_info")
public class UserInfo {

	@Id
	@Column(name="uerid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="username")
	private String username;
	
	@Column(name="address")
	private String address;
	
	@Column(name="age")
	private int age;
	
	@Column(name="subnewsletter")
	private boolean subnewsletter;
	
	@Column(name="frameworks")
	private String frameworks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSubnewsletter() {
		return subnewsletter;
	}

	public void setSubnewsletter(boolean subnewsletter) {
		this.subnewsletter = subnewsletter;
	}

	public String getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(String frameworks) {
		this.frameworks = frameworks;
	}
}
