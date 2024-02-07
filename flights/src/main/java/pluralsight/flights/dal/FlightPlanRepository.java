package pluralsight.flights.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import pluralsight.flights.domain.FlightPlan;

public interface FlightPlanRepository extends MongoRepository<FlightPlan,String> {
}
