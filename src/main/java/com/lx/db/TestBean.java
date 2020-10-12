package com.lx.db;

public class TestBean {
	
	private int id;
	private String name;
	private String pVar;
	private int pInt;
	private int country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpVar() {
		return pVar;
	}
	public void setpVar(String pVar) {
		this.pVar = pVar;
	}
	public int getpInt() {
		return pInt;
	}
	public void setpInt(int pInt) {
		this.pInt = pInt;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "TestBean [id=" + id + ", name=" + name + ", pVar=" + pVar
				+ ", pInt=" + pInt + ", country=" + country + "]";
	}


}
