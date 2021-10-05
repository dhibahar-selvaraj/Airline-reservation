package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the AIR_BOOKING database table.
 * 
 */
@Entity
@Table(name="AIR_BOOKING")
@NamedQuery(name="AirBooking.findAll", query="SELECT a FROM AirBooking a")
public class AirBooking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="BOOKING_ID")
	private Integer bookingId;

	@Column(name="BOOKING_DATE")
	private Timestamp bookingDate;

	@Column(name="BOOKING_STATUS")
	private String bookingStatus;

	@Column(name="BUSSINESS_SEATS_BOOKED")
	private int bussinessSeatsBooked;

	@Column(name="ECONOMY_SEATS_BOOKED")
	private int economySeatsBooked;

	@Column(name="JOURNEY_TYPE")
	private String journeyType;

	@Column(name="TOTAL_COST")
	private int totalCost;

	//bi-directional many-to-one association to AirBooking
	@ManyToOne
	@JoinColumn(name="RETURN_ID")
	private AirBooking airBooking;

	//bi-directional many-to-one association to AirBooking
	@OneToMany(mappedBy="airBooking", fetch=FetchType.EAGER)
	private List<AirBooking> airBookings;

	//bi-directional many-to-one association to AirFlight
	@ManyToOne
	@JoinColumn(name="FLIGHT_ID")
	private AirFlight airFlight;

	//bi-directional many-to-one association to AirTransaction
	@ManyToOne
	@JoinColumn(name="TRANSACTION_ID")
	private AirTransaction airTransaction;

	//bi-directional many-to-one association to AirUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private AirUser airUser;

	//bi-directional one-to-one association to AirCancellation
	@OneToOne(mappedBy="airBooking")
	private AirCancellation airCancellation;

	//bi-directional many-to-one association to AirPassengerticketbook
	@OneToMany(mappedBy="airBooking", fetch=FetchType.EAGER)
	private List<AirPassengerticketbook> airPassengerticketbooks;

	public AirBooking() {
	}

	public Integer getBookingId() {
		return this.bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Timestamp getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getBookingStatus() {
		return this.bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public int getBussinessSeatsBooked() {
		return this.bussinessSeatsBooked;
	}

	public void setBussinessSeatsBooked(int i) {
		this.bussinessSeatsBooked = i;
	}

	public int getEconomySeatsBooked() {
		return this.economySeatsBooked;
	}

	public void setEconomySeatsBooked(int economySeatsBooked) {
		this.economySeatsBooked = economySeatsBooked;
	}

	public String getJourneyType() {
		return this.journeyType;
	}

	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}

	public int getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(int i) {
		this.totalCost = i;
	}

	@JsonIgnore
	public AirBooking getAirBooking() {
		return this.airBooking;
	}

	public void setAirBooking(AirBooking airBooking) {
		this.airBooking = airBooking;
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
		airBooking.setAirBooking(this);

		return airBooking;
	}

	public AirBooking removeAirBooking(AirBooking airBooking) {
		getAirBookings().remove(airBooking);
		airBooking.setAirBooking(null);

		return airBooking;
	}

	public AirFlight getAirFlight() {
		return this.airFlight;
	}

	public void setAirFlight(AirFlight airFlight) {
		this.airFlight = airFlight;
	}

	public AirTransaction getAirTransaction() {
		return this.airTransaction;
	}

	public void setAirTransaction(AirTransaction airTransaction) {
		this.airTransaction = airTransaction;
	}

	public AirUser getAirUser() {
		return this.airUser;
	}

	public void setAirUser(AirUser airUser) {
		this.airUser = airUser;
	}

	public AirCancellation getAirCancellation() {
		return this.airCancellation;
	}

	public void setAirCancellation(AirCancellation airCancellation) {
		this.airCancellation = airCancellation;
	}

	
	public List<AirPassengerticketbook> getAirPassengerticketbooks() {
		return this.airPassengerticketbooks;
	}

	public void setAirPassengerticketbooks(List<AirPassengerticketbook> airPassengerticketbooks) {
		this.airPassengerticketbooks = airPassengerticketbooks;
	}

	public AirPassengerticketbook addAirPassengerticketbook(AirPassengerticketbook airPassengerticketbook) {
		getAirPassengerticketbooks().add(airPassengerticketbook);
		airPassengerticketbook.setAirBooking(this);

		return airPassengerticketbook;
	}

	public AirPassengerticketbook removeAirPassengerticketbook(AirPassengerticketbook airPassengerticketbook) {
		getAirPassengerticketbooks().remove(airPassengerticketbook);
		airPassengerticketbook.setAirBooking(null);

		return airPassengerticketbook;
	}

}