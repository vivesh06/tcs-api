package com.tcs.api.model;

import java.util.Base64;

public class Content {

	private String format;
	private String data;
	private String location;
	private String encoding;
	private String mediaType;
	
	public Content() {
	}
	
	public Content(String format, String data, String location, String encoding, String mediaType) {
		this.format = format;
		this.data = data;
		this.location = location;
		this.encoding = encoding;
		this.mediaType = mediaType;
	}

	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	public byte[] toBytes() { 
		if(null == data) return null;
		if(format.equalsIgnoreCase("base64")) { //TODO
			return Base64.getDecoder().decode(data);
		}
		return null;
	}
	
	public boolean hasBinaryContent() {
		return null != data && !data.isEmpty();
	}
}
