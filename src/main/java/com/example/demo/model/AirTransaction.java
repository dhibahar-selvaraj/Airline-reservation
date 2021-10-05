package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the AIR_TRANSACTION database table.
 * 
 */
@Entity
@Table(name="AIR_TRANSACTION")
@NamedQuery(name="AirTransaction.findAll", query="SELECT a FROM AirTransaction a")
public class AirTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRANSACTION_ID")
	private int transactionId;

	@Column(name="TRANSACTION_AMOUNT")
	private double transactionAmount;

	@Column(name="TRANSACTION_MODE")
	private String transactionMode;

	@Column(name="TRANSACTION_STATUS")
	private String transactionStatus;

	@Column(name="TRANSACTION_TYPE")
	private String transactionType;

	//bi-directional many-to-one association to AirBooking
	@OneToMany(mappedBy="airTransaction", fetch=FetchType.EAGER)
	private List<AirBooking> airBookings;

	//bi-directional many-to-one association to AirCancellation
	@OneToMany(mappedBy="airTransaction", fetch=FetchType.EAGER)
	private List<AirCancellation> airCancellations;

	public AirTransaction() {
	}

	public long getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(double d) {
		this.transactionAmount = d;
	}

	public String getTransactionMode() {
		return this.transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionStatus() {
		return this.transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
		airBooking.setAirTransaction(this);

		return airBooking;
	}

	public AirBooking removeAirBooking(AirBooking airBooking) {
		getAirBookings().remove(airBooking);
		airBooking.setAirTransaction(null);

		return airBooking;
	}

	@JsonIgnore
	public List<AirCancellation> getAirCancellations() {
		return this.airCancellations;
	}

	public void setAirCancellations(List<AirCancellation> airCancellations) {
		this.airCancellations = airCancellations;
	}

	public AirCancellation addAirCancellation(AirCancellation airCancellation) {
		getAirCancellations().add(airCancellation);
		airCancellation.setAirTransaction(this);

		return airCancellation;
	}

	public AirCancellation removeAirCancellation(AirCancellation airCancellation) {
		getAirCancellations().remove(airCancellation);
		airCancellation.setAirTransaction(null);

		return airCancellation;
	}

}