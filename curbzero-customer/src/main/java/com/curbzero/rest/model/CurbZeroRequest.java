package com.curbzero.rest.model;

import java.io.Serializable;

public class CurbZeroRequest implements Serializable {

	private static final long serialVersionUID = -8706326026071769136L;

	String clat;
	String clong;
	String orderId;
	String status;
	String custId;
	String storeId;
	public String getClat() {
		return clat;
	}
	public void setClat(String clat) {
		this.clat = clat;
	}
	public String getClong() {
		return clong;
	}
	public void setClong(String clong) {
		this.clong = clong;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
