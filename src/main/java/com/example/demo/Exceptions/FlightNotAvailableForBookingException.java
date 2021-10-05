package com.example.demo.Exceptions;

public class FlightNotAvailableForBookingException extends RuntimeException {

	public FlightNotAvailableForBookingException(String message) {
		super(message);
	}
}