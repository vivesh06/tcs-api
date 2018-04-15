package com.tcs.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class TermsAndConditions {
	
	@Id
	private long id;
	
	private String name;
	
	private List<String> channels = new ArrayList<>();
	
	private Date createdOn;
	
	private Date expiresOn;
	
	private Content content;
	
	private String version;
	
	private Date invalidatedOn;
	
	private String status;
	
	public TermsAndConditions() {
	}
	
	public TermsAndConditions(long id, String name, Date createdOn, Date expiresOn, String version) {
		this.id = id;
		this.name = name;
		this.createdOn = createdOn;
		this.expiresOn = expiresOn;
		this.version = version;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getExpiresOn() {
		return expiresOn;
	}
	public void setExpiresOn(Date expiresOn) {
		this.expiresOn = expiresOn;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
	public List<String> getChannels() {
		return channels;
	}
	
}
