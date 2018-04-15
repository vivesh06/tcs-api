package com.tcs.api.model;

import java.util.ArrayList;
import java.util.List;

public class UserAcceptance {

	private long id;
	private String clientKey;
	private String clientKeyType;
	private List<AcceptanceRecord> acceptances = new ArrayList<>();
	
	public UserAcceptance() {
	}
	
	public UserAcceptance(long id, String clientKey, String clientKeyType, List<AcceptanceRecord> acceptances) {
		this.id = id;
		this.clientKey = clientKey;
		this.clientKeyType = clientKeyType;
		this.acceptances = acceptances;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getClientKeyType() {
		return clientKeyType;
	}
	public void setClientKeyType(String clientKeyType) {
		this.clientKeyType = clientKeyType;
	}
	public List<AcceptanceRecord> getAcceptances() {
		return acceptances;
	}
	
	
	
}
