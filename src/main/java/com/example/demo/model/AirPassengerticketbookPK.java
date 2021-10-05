package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AIR_PASSENGERTICKETBOOK database table.
 * 
 */
@Embeddable
public class AirPassengerticketbookPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PASSENGER_ID", insertable=false, updatable=false)
	private long passengerId;

	@Column(name="TICKET_ID", insertable=false, updatable=false)
	private long ticketId;

	public AirPassengerticketbookPK() {
	}
	public long getPassengerId() {
		return this.passengerId;
	}
	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}
	public long getTicketId() {
		return this.ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AirPassengerticketbookPK)) {
			return false;
		}
		AirPassengerticketbookPK castOther = (AirPassengerticketbookPK)other;
		return 
			(this.passengerId == castOther.passengerId)
			&& (this.ticketId == castOther.ticketId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.passengerId ^ (this.passengerId >>> 32)));
		hash = hash * prime + ((int) (this.ticketId ^ (this.ticketId >>> 32)));
		
		return hash;
	}
}