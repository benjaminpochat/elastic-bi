package org.elasticbi.sample.pojo;

import java.time.Instant;

public class Booking {
	private BookingStatus status;
	private Country country;
	private String id;
	private int nbOfPeople;
	private Instant creationDate;
	
	public BookingStatus getStatus() {
		return status;
	}
	
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getNbOfPeople() {
		return nbOfPeople;
	}

	public void setNbOfPeople(int nbOfPeople) {
		this.nbOfPeople = nbOfPeople;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

}
