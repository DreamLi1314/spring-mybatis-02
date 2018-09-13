package com.dreamli.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private int id;
	private String username;
	private Date birthday;
	private char sex;
	private String address;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, Date birthday, char sex, String address) {
		super();
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

	public User(int id, String username, Date birthday, char sex, String address) {
		super();
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
	}

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}

}
