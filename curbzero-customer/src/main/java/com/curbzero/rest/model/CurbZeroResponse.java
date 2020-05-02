package com.curbzero.rest.model;

import java.io.Serializable;

public class CurbZeroResponse implements Serializable {

	private static final long serialVersionUID = -6755253109032856351L;

	private String curbResponse;
	private String status;
	private String estDistance;
	private int nextPing;
	
	public String getCurbResponse() {
		return curbResponse;
	}
	public void setCurbResponse(String curbResponse) {
		this.curbResponse = curbResponse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEstDistance() {
		return estDistance;
	}
	public void setEstDistance(String estDistance) {
		this.estDistance = estDistance;
	}
	public int getNextPing() {
		return nextPing;
	}
	public void setNextPing(int nextPing) {
		this.nextPing = nextPing;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
