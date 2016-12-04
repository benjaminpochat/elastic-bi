package org.elasticbi.sample.service;

import java.io.IOException;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticbi.sample.pojo.Booking;
import org.elasticbi.sample.pojo.BookingStatus;
import org.elasticbi.sample.pojo.Country;

/**
 * Generates bookings, and makes them progress into the following the process :
 * ORDERD -> PREPAID -> CONSUMED
 * 
 * The country, the bookingId, the nb of people and the date when status changes are determined randomly
 */
public class BookingSimulator {
	
	private Random random = new Random();
	private int nbOfBookings;
	private Instant start;
	private Instant end;

	public BookingSimulator(int nbOfBookings, Instant start, Instant end) {
		super();
		this.nbOfBookings = nbOfBookings;
		this.start = start;
		this.end = end;
	}
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		int nbOfBookings = Integer.valueOf(args[0]).intValue();
		Instant start = Instant.parse(args[1]);
		Instant end = Instant.parse(args[2]);
		BookingSimulator simulator = new BookingSimulator(nbOfBookings, start, end);
		simulator.simulate();
	}

	public void simulate() throws JsonGenerationException, JsonMappingException, IOException{
		for(int i = 0 ; i < nbOfBookings ; i++){
			Booking booking = createBooking();
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(booking));
			
			processBooking(booking);
		}		
	}
	
	private Booking createBooking() {
		Booking booking = new Booking();
		booking.setId(UUID.randomUUID().toString());
		booking.setCountry(getRandomCountry());
		booking.setStatus(BookingStatus.ORDERED);
		booking.setNbOfPeople(this.random.nextInt(4));
		booking.setCreationDate(getRandomInstant(start, end));
		
		
		return booking;
	}

	private void processBooking(Booking booking) {
		
	}

	private Country getRandomCountry(){
		Random random = new Random();
		int i = random.nextInt(Country.class.getEnumConstants().length);
		return Country.class.getEnumConstants()[i];
	}
	
	private Instant getRandomInstant(Instant min, Instant max){
		long longMin = min.getEpochSecond();
		long longMax = max.getEpochSecond();
		long randomValue = longMin + (long)(random.nextDouble()*(longMax - longMin));
		return Instant.ofEpochSecond(randomValue);
	}
	
}
