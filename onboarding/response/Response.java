package com.bl.onboarding.response;

import org.springframework.stereotype.Component;

@Component
public class Response {

	private Long statusCode;
	private String message;
	private Object token;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(long l) {
		this.statusCode = l;
	}

	public Object getToken() {
		return token;
	}

	public void setToken(Object token) {
		this.token = token;
	}

	public Response(String message, Long statusCode, Object token) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.token = token;
	}
	
	public Response(String message, Long statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	public Response() {

	}
}
