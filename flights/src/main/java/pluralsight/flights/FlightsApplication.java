package pluralsight.flights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import pluralsight.flights.dal.converters.AircraftWriteConverter;

import java.util.ArrayList;

@SpringBootApplication
public class FlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
	}

	@Bean
	public MongoCustomConversions mongoCustomConversions(){

		var list = new ArrayList<>();
		list.add(new AircraftWriteConverter());
		return new MongoCustomConversions(list);
	}

}
