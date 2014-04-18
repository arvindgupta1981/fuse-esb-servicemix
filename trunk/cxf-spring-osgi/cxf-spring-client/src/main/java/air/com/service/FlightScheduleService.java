package air.com.service;

import javax.jws.WebService;

@WebService
public interface FlightScheduleService {
	String getFlightTime(String flightId);
}
