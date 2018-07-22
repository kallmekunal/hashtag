package com.kunal.project.domain;

public class User {
	
	   private String username;
	   private int age;
	   private String address;
	   private boolean receivePaper;
	   private String [] favoriteFrameworks;   

	   public String getUsername() {
	      return username;
	   }
//	   @Loggable
	   public void setUsername(String username) {
	      this.username = username;
	   }

	   public String getAddress() {
	      return address;
	   }
	   public void setAddress(String address) {
	      this.address = address;
	   }
	   public boolean isReceivePaper() {
	      return receivePaper;
	   }
	   public void setReceivePaper(boolean receivePaper) {
	      this.receivePaper = receivePaper;
	   }
	   public String[] getFavoriteFrameworks() {
	      return favoriteFrameworks;
	   }
	   public void setFavoriteFrameworks(String[] favoriteFrameworks) {
	      this.favoriteFrameworks = favoriteFrameworks;
	   }
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	}