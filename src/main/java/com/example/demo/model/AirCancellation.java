package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the AIR_CANCELLATION database table.
 * 
 */
@Entity
@Table(name="AIR_CANCELLATION")
@NamedQuery(name="AirCancellation.findAll", query="SELECT a FROM AirCancellation a")
public class AirCancellation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CANCELLATION_ID")
	private int cancellationId;

	@Column(name="CANCELLATION_DATE")
	private Timestamp cancellationDate;

	@Column(name="CANCELLATION_REASON")
	private String cancellationReason;

	@Column(name="CANCELLATION_STATUS")
	private String cancellationStatus;

	@Column(name="REFUND_AMOUNT")
	private int refundAmount;

	//bi-directional one-to-one association to AirBooking
	@OneToOne
	@JoinColumn(name="CANCELLATION_ID")
	private AirBooking airBooking;

	//bi-directional many-to-one association to AirTransaction
	@ManyToOne
	@JoinColumn(name="TRANSACTION_ID")
	private AirTransaction airTransaction;

	public AirCancellation() {
	}

	public int getCancellationId() {
		return this.cancellationId;
	}

	public void setCancellationId(int cancellationId) {
		this.cancellationId = cancellationId;
	}

	public Timestamp getCancellationDate() {
		return this.cancellationDate;
	}

	public void setCancellationDate(Timestamp cancellationDate) {
		this.cancellationDate = cancellationDate;
	}

	public String getCancellationReason() {
		return this.cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public String getCancellationStatus() {
		return this.cancellationStatus;
	}

	public void setCancellationStatus(String cancellationStatus) {
		this.cancellationStatus = cancellationStatus;
	}

	public int getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	@JsonIgnore
	public AirBooking getAirBooking() {
		return this.airBooking;
	}

	public void setAirBooking(AirBooking airBooking) {
		this.airBooking = airBooking;
	}

	public AirTransaction getAirTransaction() {
		return this.airTransaction;
	}

	public void setAirTransaction(AirTransaction airTransaction) {
		this.airTransaction = airTransaction;
	}

}