package com.rocksoft.LogStr.address;

public class Address {

	private String country;
	private String city;
	private String street;
	private String homeNumber;
	private Region region;
	public enum Region{	MINSKY, VITEBSKY, MOGILEVSKY, GOMELSKY, BRESTSKY, GRONENSKY}
		
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region){
		this.region = region;
	}
	public Address() {
		this.country = "Belarus";
		this.city = "Minsk";
		this.street = "Partizanski";
		this.homeNumber = "25a";
	}
	public Address(String country, String city, String street, String homeNumber, String appartement) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.homeNumber = homeNumber;
	}
	public Address(String country, String city, String street, String homeNumber) {
		this.country = country;
		this.city = city;
		this.street = street;
		this.homeNumber = homeNumber;
	}
	public Address(String country, String city, String street) {
		this.country = country;
		this.city = city;
		this.street = street;
	}
	public Address(String country, String city) {
		this.country = country;
		this.city = city;
	}
	public Address(String country) {
		this.country = country;
	}
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	

	public void getYourAddress() {
		System.out.println(
				"Country: " + this.country + "\nCity: " + this.city + "\nStreet: " + this.street + " " + "\nHome number: " + this.homeNumber);

	}
	
	@Override
	public String toString() {
		return country + " " + region.name();
	}
}
