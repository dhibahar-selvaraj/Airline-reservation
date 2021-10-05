package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the AIR_PASSENGERTICKETBOOK database table.
 * 
 */
@Entity
@Table(name="AIR_PASSENGERTICKETBOOK")
@NamedQuery(name="AirPassengerticketbook.findAll", query="SELECT a FROM AirPassengerticketbook a")
public class AirPassengerticketbook implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AirPassengerticketbookPK id;

	@Column(name="SEAT_NUMBER")
	private int seatNumber;
	//bi-directional many-to-one association to AirBooking
	@ManyToOne
	@JoinColumn(name="TICKET_ID", insertable=false, updatable=false)
	private AirBooking airBooking;

	//bi-directional many-to-one association to AirPassenger
	@ManyToOne
	@JoinColumn(name="PASSENGER_ID", insertable=false, updatable=false)
	private AirPassenger airPassenger;

	public AirPassengerticketbook() {
	}

	public AirPassengerticketbookPK getId() {
		return this.id;
	}

	public void setId(AirPassengerticketbookPK id) {
		this.id = id;
	}

	public int getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	@JsonIgnore
	public AirBooking getAirBooking() {
		return this.airBooking;
	}

	public void setAirBooking(AirBooking airBooking) {
		this.airBooking = airBooking;
	}

	public AirPassenger getAirPassenger() {
		return this.airPassenger;
	}

	public void setAirPassenger(AirPassenger airPassenger) {
		this.airPassenger = airPassenger;
	}

}