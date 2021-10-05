package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AIR_FLIGHTSEATS database table.
 * 
 */
@Entity
@Table(name="AIR_FLIGHTSEATS")
@NamedQuery(name="AirFlightseat.findAll", query="SELECT a FROM AirFlightseat a")
public class AirFlightseat implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="SEAT_NUMBER")
	private int seatNumber;

	@Column(name="SEAT_TYPE")
	private String seatType;

	public AirFlightseat() {
	}

	public int getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getSeatType() {
		return this.seatType;
	}

	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

}