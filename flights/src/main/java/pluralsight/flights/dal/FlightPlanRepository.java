package pluralsight.flights.dal;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pluralsight.flights.domain.FlightPlan;

import java.util.List;

@Repository
public interface FlightPlanRepository extends MongoRepository<FlightPlan,String> {
    List<FlightPlan> findByFlightDurationBetween(int minDuration, int maxDuration, PageRequest pageRequest);
    List<FlightPlan> findByAircraftModelContainsOrderByAircraftSeatCapacity(String model);

    @Query("{'isInternational' : true, 'crossedCountries': {'$in' : [?0]}}")
    List<FlightPlan> findInternationalCrossing(String country);



}
