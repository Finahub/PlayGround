package com.finahub.dao;

import java.io.Serializable;

public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;

	private String message;

	private transient Object data;

	public ApiResponse(int status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
