package com.tcs.api.model;

import java.util.Date;

public class AcceptanceRecord {

	private long tcsKey;
	private String channel;
	private String module;
	private Date acceptedOn;
	private Date expiresOn;
	private Date invalidatedOn;
	private String status;
	private String mode;
	private String reference;
	private Content document;
	
	public long getTcsKey() {
		return tcsKey;
	}
	public void setTcsKey(long tcsKey) {
		this.tcsKey = tcsKey;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public Date getAcceptedOn() {
		return acceptedOn;
	}
	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}
	public Date getExpiresOn() {
		return expiresOn;
	}
	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}
	public Date getInvalidatedOn() {
		return invalidatedOn;
	}
	public void setInvalidatedOn(Date invalidatedOn) {
		this.invalidatedOn = invalidatedOn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Content getDocument() {
		return document;
	}
	public void setDocument(Content document) {
		this.document = document;
	}
	
}
