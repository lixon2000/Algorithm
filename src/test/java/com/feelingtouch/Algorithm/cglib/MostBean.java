package com.feelingtouch.Algorithm.cglib;

public class MostBean {
	
	private int uid;
	private String name;
	private boolean monster;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMonster() {
		return monster;
	}
	public void setMonster(boolean monster) {
		this.monster = monster;
	}
	public int fight(){
		System.out.println("fight");
		return 1;
	}
	public void hitTool(){
		System.out.println("hitTool");
	}
	public boolean hide(){
		System.out.println("hide");
		return true;
	}

}
