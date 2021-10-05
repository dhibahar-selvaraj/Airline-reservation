package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the AIR_USER database table.
 * 
 */
@Entity
@Table(name="AIR_USER")
@NamedQuery(name="AirUser.findAll", query="SELECT a FROM AirUser a")
public class AirUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private int userId;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	@Column(name="PH_NO")
	private BigDecimal phNo;

	//bi-directional many-to-one association to AirBooking
	@OneToMany(mappedBy="airUser", fetch=FetchType.EAGER)
	private List<AirBooking> airBookings;

	//bi-directional many-to-one association to AirPassenger
	@OneToMany(mappedBy="airUser", fetch=FetchType.EAGER)
	private List<AirPassenger> airPassengers;

	public AirUser() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getPhNo() {
		return this.phNo;
	}

	public void setPhNo(BigDecimal phNo) {
		this.phNo = phNo;
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
		airBooking.setAirUser(this);

		return airBooking;
	}

	public AirBooking removeAirBooking(AirBooking airBooking) {
		getAirBookings().remove(airBooking);
		airBooking.setAirUser(null);

		return airBooking;
	}

	@JsonIgnore
	public List<AirPassenger> getAirPassengers() {
		return this.airPassengers;
	}

	public void setAirPassengers(List<AirPassenger> airPassengers) {
		this.airPassengers = airPassengers;
	}

	public AirPassenger addAirPassenger(AirPassenger airPassenger) {
		getAirPassengers().add(airPassenger);
		airPassenger.setAirUser(this);

		return airPassenger;
	}

	public AirPassenger removeAirPassenger(AirPassenger airPassenger) {
		getAirPassengers().remove(airPassenger);
		airPassenger.setAirUser(null);

		return airPassenger;
	}

}