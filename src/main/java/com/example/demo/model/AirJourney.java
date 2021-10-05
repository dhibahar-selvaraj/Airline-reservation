package com.example.demo.model;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the AIR_JOURNEY database table.
 * 
 */
@Entity
@Table(name="AIR_JOURNEY")
@NamedQuery(name="AirJourney.findAll", query="SELECT a FROM AirJourney a")
public class AirJourney implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="JOURNEY_ID")
	private int journeyId;

	@Column(name="DESTINATION_LOC")
	private String destinationLoc;

	@Column(name="SOURCE_LOC")
	private String sourceLoc;

	//bi-directional many-to-one association to AirFlight
	@OneToMany(mappedBy="airJourney", fetch=FetchType.EAGER)
	private List<AirFlight> airFlights;

	public AirJourney() {
	}

	public long getJourneyId() {
		return this.journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public String getDestinationLoc() {
		return this.destinationLoc;
	}

	public void setDestinationLoc(String destinationLoc) {
		this.destinationLoc = destinationLoc;
	}

	public String getSourceLoc() {
		return this.sourceLoc;
	}

	public void setSourceLoc(String sourceLoc) {
		this.sourceLoc = sourceLoc;
	}

	@JsonIgnore
	public List<AirFlight> getAirFlights() {
		return this.airFlights;
	}

	public void setAirFlights(List<AirFlight> airFlights) {
		this.airFlights = airFlights;
	}

	public AirFlight addAirFlight(AirFlight airFlight) {
		getAirFlights().add(airFlight);
		airFlight.setAirJourney(this);

		return airFlight;
	}

	public AirFlight removeAirFlight(AirFlight airFlight) {
		getAirFlights().remove(airFlight);
		airFlight.setAirJourney(null);

		return airFlight;
	}

}