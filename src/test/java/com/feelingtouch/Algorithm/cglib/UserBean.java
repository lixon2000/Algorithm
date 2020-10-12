package com.feelingtouch.Algorithm.cglib;

public class UserBean {
	
	private int uid = 1;
	private String name = "name1";
	private boolean monster = false;
	
	public UserBean() {
		super();
	}
	
	public final int getUid() {
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

	@Override
	public final String toString() {
		return "UserBean [uid=" + uid + ", name=" + name + ", monster="
				+ monster + "]";
	}

}
