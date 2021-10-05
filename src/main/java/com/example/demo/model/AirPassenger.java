package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the AIR_PASSENGER database table.
 * 
 */
@Entity
@Table(name="AIR_PASSENGER")
@NamedQuery(name="AirPassenger.findAll", query="SELECT a FROM AirPassenger a")
public class AirPassenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PASSENGER_ID")
	private int passengerId;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	//bi-directional many-to-one association to AirUser
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private AirUser airUser;

	//bi-directional many-to-one association to AirPassengerticketbook
	@OneToMany(mappedBy="airPassenger", fetch=FetchType.EAGER)
	private List<AirPassengerticketbook> airPassengerticketbooks;

	public AirPassenger() {
	}

	public long getPassengerId() {
		return this.passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AirUser getAirUser() {
		return this.airUser;
	}

	public void setAirUser(AirUser airUser) {
		this.airUser = airUser;
	}

	@JsonIgnore
	public List<AirPassengerticketbook> getAirPassengerticketbooks() {
		return this.airPassengerticketbooks;
	}

	public void setAirPassengerticketbooks(List<AirPassengerticketbook> airPassengerticketbooks) {
		this.airPassengerticketbooks = airPassengerticketbooks;
	}

	public AirPassengerticketbook addAirPassengerticketbook(AirPassengerticketbook airPassengerticketbook) {
		getAirPassengerticketbooks().add(airPassengerticketbook);
		airPassengerticketbook.setAirPassenger(this);

		return airPassengerticketbook;
	}

	public AirPassengerticketbook removeAirPassengerticketbook(AirPassengerticketbook airPassengerticketbook) {
		getAirPassengerticketbooks().remove(airPassengerticketbook);
		airPassengerticketbook.setAirPassenger(null);

		return airPassengerticketbook;
	}

}