package pluralsight.flights;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pluralsight.flights.dal.FlightPlanDataService;

import java.time.LocalDateTime;

/*
This component will be executed by Spring Framework immediately after application
bootstrap
 */
@Component
public class MainRunner implements CommandLineRunner {
    private FlightPlanDataService flightPlanDataService ;
    public MainRunner(@Qualifier("flightPlanRepositoryDataService") FlightPlanDataService flightPlanDataService) {
        this.flightPlanDataService =flightPlanDataService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.flightPlanDataService.deleteAll();

    }
}
