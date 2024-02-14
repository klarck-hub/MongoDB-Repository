package pluralsight.flights;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.AircraftRepository;
import pluralsight.flights.dal.FlightPlanDataService;
import pluralsight.flights.dal.FlightPlanRepository;
import pluralsight.flights.domain.AircraftFactory;
import pluralsight.flights.domain.FlightPlan;

import java.time.LocalDateTime;
import java.util.List;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private AircraftRepository aircraftRepository;

    private FlightPlanRepository flightPlanRepository;
    public MainRunner(FlightPlanRepository flightPlanRepository, AircraftRepository aircraftRepository) {
        this.flightPlanRepository = flightPlanRepository;
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        aircraftRepository.deleteAll();
        flightPlanRepository.deleteAll();


        flightPlanRepository.insert( new FlightPlan(
                "Vienna",
                "Bucharest",
                LocalDateTime.now(),
                60*70,
                List.of("Austria","Hungary","Romania"),
                true,
                AircraftFactory.buildEmbraerE175()

        ));



    }
}
