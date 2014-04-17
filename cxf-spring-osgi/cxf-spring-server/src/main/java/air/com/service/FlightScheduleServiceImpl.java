package air.com.service;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface = "air.com.service.FlightScheduleService")
public class FlightScheduleServiceImpl implements FlightScheduleService {
	public String getFlightTime(String flightId) {
		return new Date().toGMTString();
	}
}	
	
