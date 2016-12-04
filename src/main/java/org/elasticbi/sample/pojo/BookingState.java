package org.elasticbi.sample.pojo;

import java.time.Instant;

import org.elasticbi.core.pojo.State;

public class BookingState implements State<Booking> {

	private Booking booking;
	private Instant startTime;
	private Instant endTime;
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public Instant getStartTime() {
		return startTime;
	}

	@Override
	public Instant getEndTime() {
		return endTime;
	}

	@Override
	public Booking getPojo() {
		return getBooking();
	}

}
