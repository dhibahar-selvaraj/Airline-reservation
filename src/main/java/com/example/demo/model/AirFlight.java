package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AIR_FLIGHT database table.
 * 
 */
@Entity
@Table(name="AIR_FLIGHT")
@NamedQuery(name="AirFlight.findAll", query="SELECT a FROM AirFlight a")
public class AirFlight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FLIGHT_ID")
	private int flightId;

	@Column(name="ARRIVAL_DATETIME")
	private Timestamp arrivalDatetime;

	@Column(name="AVAILABLE_BUSSINESS_SEATS")
	private int availableBussinessSeats;

	@Column(name="AVAILABLE_ECONOMY_SEATS")
	private int availableEconomySeats;

	@Column(name="BUSSINESS_CLASS_PRICE")
	private int bussinessClassPrice;

	@Column(name="DEPARTURE_DATETIME")
	private Timestamp departureDatetime;

	@Column(name="ECONOMY_CLASS_PRICE")
	private int economyClassPrice;

	@Column(name="FLIGHT_NAME")
	private String flightName;

	@Column(name="FLIGHT_STATUS")
	private String flightStatus;

	//bi-directional many-to-one association to AirBooking
	@OneToMany(mappedBy="airFlight", fetch=FetchType.EAGER)
	private List<AirBooking> airBookings;

	//bi-directional many-to-one association to AirJourney
	@ManyToOne
	@JoinColumn(name="JOURNEY_ID")
	private AirJourney airJourney;

	public AirFlight() {
	}

	public long getFlightId() {
		return this.flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Timestamp getArrivalDatetime() {
		return this.arrivalDatetime;
	}

	public void setArrivalDatetime(Timestamp arrivalDatetime) {
		this.arrivalDatetime = arrivalDatetime;
	}

	public int getAvailableBussinessSeats() {
		return this.availableBussinessSeats;
	}

	public void setAvailableBussinessSeats(int i) {
		this.availableBussinessSeats = i;
	}

	public int getAvailableEconomySeats() {
		return this.availableEconomySeats;
	}

	public void setAvailableEconomySeats(int availableEconomySeats) {
		this.availableEconomySeats = availableEconomySeats;
	}

	public int getBussinessClassPrice() {
		return this.bussinessClassPrice;
	}

	public void setBussinessClassPrice(int bussinessClassPrice) {
		this.bussinessClassPrice = bussinessClassPrice;
	}

	public Timestamp getDepartureDatetime() {
		return this.departureDatetime;
	}

	public void setDepartureDatetime(Timestamp departureDatetime) {
		this.departureDatetime = departureDatetime;
	}

	public int getEconomyClassPrice() {
		return this.economyClassPrice;
	}

	public void setEconomyClassPrice(int economyClassPrice) {
		this.economyClassPrice = economyClassPrice;
	}

	public String getFlightName() {
		return this.flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightStatus() {
		return this.flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	@JsonIgnore
	public List<AirBooking> getAirBookings() {
		return this.airBookings;
	}

	public void setAirBookings(List<AirBooking> airBookings) {
		this.airBookings = airBookings;
	}

	public AirBooking addAirBooking(AirBooking airBooking) {
		getAirBookings().add(airBooking);
		airBooking.setAirFlight(this);

		return airBooking;
	}

	public AirBooking removeAirBooking(AirBooking airBooking) {
		getAirBookings().remove(airBooking);
		airBooking.setAirFlight(null);

		return airBooking;
	}

	public AirJourney getAirJourney() {
		return this.airJourney;
	}

	public void setAirJourney(AirJourney airJourney) {
		this.airJourney = airJourney;
	}

}