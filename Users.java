package com.deloitte.bean;

public class Users {
private String name;
private String desig;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesig() {
	return desig;
}
public void setDesig(String desig) {
	this.desig = desig;
}
public Users() {
	super();

}
public Users(String name, String desig) {
	super();
	this.name = name;
	this.desig = desig;
	
}
}