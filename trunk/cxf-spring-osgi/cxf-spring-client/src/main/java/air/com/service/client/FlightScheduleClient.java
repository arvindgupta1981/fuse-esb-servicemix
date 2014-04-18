package air.com.service.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import air.com.service.FlightScheduleService;

public class FlightScheduleClient {
	public static void main(String...l) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:client-beans.xml");
		FlightScheduleService flightScheduleService = (FlightScheduleService)ctx.getBean("flightScheduleServiceClient");
		System.out.println(flightScheduleService.getFlightTime(""));
	}
}
