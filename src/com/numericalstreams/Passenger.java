package com.numericalstreams;


import java.util.ArrayList;

public class Passenger {
	private int PNRid;
	private String name;
	private int age;
	private String gender;
	private String from;
	private String to;
	private int fare;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getPNRid() {
		return PNRid;
	}

	public void setPNRid(int PNRid) {
		this.PNRid = PNRid;
	}

	public Passenger(int PNRid, String name, int age, String gender, String from, String to, int fare) {
		super();
		this.PNRid = PNRid;
		this.name = name;
		this.age=age;
		this.gender = gender;
		this.from = from;
		this.to = to;
		this.fare = fare;
	}

	public static void main(String[] args) {
		ArrayList<Passenger> listPassenger=new ArrayList<>();
		Passenger pn=new Passenger(111,"jakkam",21,"Male","hyderabad","tirupati",800);
		listPassenger.add(pn);
		listPassenger.add(new Passenger(123,"jakkam",21,"Male","hyderabad","tirupati",800));
		listPassenger.add(new Passenger(123,"jakkam",21,"Male","hyderabad","tirupati",800));
		listPassenger.add(new Passenger(123,"jakkam",21,"Male","hyderabad","tirupati",800));
		listPassenger.add(new Passenger(123,"jakkam",21,"Male","hyderabad","tirupati",800));
		listPassenger.add(new Passenger(123,"jakkam",21,"Male","hyderabad","tirupati",800));
		System.out.println(listPassenger);
		listPassenger.remove(pn);
		System.out.println(listPassenger);


	}

}
