package com.entity;


public class Vendor {
	private int vendorId;
	private int userId;
	private String vendorName;
	private String vendorLocation;
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorLocation() {
		return vendorLocation;
	}
	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", userId=" + userId + ", vendorName=" + vendorName
				+ ", vendorLocation=" + vendorLocation + "]";
	}
	public Vendor(int vendorId, int userId, String vendorName, String vendorLocation) {
		super();
		this.vendorId = vendorId;
		this.userId = userId;
		this.vendorName = vendorName;
		this.vendorLocation = vendorLocation;
	}
	public Vendor() {
		super();
	}
}
