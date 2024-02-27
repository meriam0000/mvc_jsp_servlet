package com.java_mvc.models;


public class book {
private  String bookname;
private String bookedition;
private Float bookprice;



public book()
{}
public book(String bookname, String bookedition, Float bookprice) {
	
	this.bookname = bookname;
	this.bookedition = bookedition;
	this.bookprice = bookprice;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getBookedition() {
	return bookedition;
}
public void setBookedition(String bookedition) {
	this.bookedition = bookedition;
}
public Float getBookprice() {
	return bookprice;
}
public void setBookprice(Float bookprice) {
	this.bookprice = bookprice;
}

}
