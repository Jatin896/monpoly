package com.consilx.monopolygame.exception.pojo;
/**
 * This class is used to have details of functional exception.
 */
import java.util.Date;

public class ApiError {
	private Date timestamp;
	private String message;
	private String details;

	public ApiError(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
