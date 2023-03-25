package com.nagarro.AccountService.dto;


public class CustomerDto {
	private Integer cid;
	private String  firstName;
	private String  lastName;
	private Integer age;
	private Long phone;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public CustomerDto() {
	}
	
	public CustomerDto(Integer cid, String firstName, String lastName, Integer age, Long phone) {
		this.cid = cid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
	}
	

}
