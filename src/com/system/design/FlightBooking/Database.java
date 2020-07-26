package com.system.design.FlightBooking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

	private static Database database = null;
	
	private Database () {init();};
	
	public static Database getInstance() {
		if(database == null) {
			database = new Database();
			return database;
		}
		return database;
	}
	
	private List<FlightSchedule> listOfFlightSchedule = new ArrayList<>();
	
	public List<FlightSchedule> getListOfFlightSchedule() {
		return listOfFlightSchedule;
	}

	public void setListOfFlightSchedule(List<FlightSchedule> listOfFlightSchedule) {
		this.listOfFlightSchedule = listOfFlightSchedule;
	}

	public void init() {
		Airport airport1 = new Airport("Heathrow", "bangalore", "121");
		
		List<FlightSeat> listofFlightSeats = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			listofFlightSeats.add(new FlightSeat("LOQ " + i*10, SeatClass.ECONOMY, i*1000, BookingStatus.AVAILABLE));
		}
		
		Flight flight1 = new Flight("1", 2, airport1, new Airport("Honty", "kolkatae", "123"));
		Flight flight2 = new Flight("122323", 4, airport1, new Airport("Honty", "kolkatae", "123"));

		FlightSchedule flightSchedule = new FlightSchedule(flight1, new Date(1992,10,10), "10", FlightStatus.ACTIVE, listofFlightSeats);

		FlightSchedule flightSchedule2 = new FlightSchedule(flight2, new Date(1992,10,10), "9", FlightStatus.ACTIVE, listofFlightSeats);
		
		listOfFlightSchedule.add(flightSchedule);
		listOfFlightSchedule.add(flightSchedule2);
		
	}
	
	
	
}
