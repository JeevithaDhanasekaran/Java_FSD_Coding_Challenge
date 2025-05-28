package com.hexaware.cricketteammanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Employee Not Found for given Eid", code = HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException{
	public InvalidInputException(String message) {
		super(message);
	}
}
