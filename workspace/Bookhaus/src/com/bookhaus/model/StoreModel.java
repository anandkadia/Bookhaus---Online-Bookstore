package com.bookhaus.model;

public class StoreModel {

	private int storeId;
	private String storeName;
	private String address;
	private String city;
	private String zip;
	private String state;
	private String phone;
	private String email;
	private String hours;
	private String latitude;
	private String longitude;
	
	private int quantity;
	
	public StoreModel(){
		
	}
	
	public StoreModel(int storeId, String storeName, String address,
			String city, String zip, String state, String phone, String email, String hours,
			String latitude, String longitude) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.phone = phone;
		this.setEmail(email);
		this.hours = hours;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
