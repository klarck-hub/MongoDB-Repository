package pluralsight.flights.dal;

import pluralsight.flights.domain.FlightPlan;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightPlanDataService {
    void insertInitialFlightPlans();

    FlightPlan findById(String id);

    List<FlightPlan> findInternationalCrossingFrance();

    List<FlightPlan> findFirstTwoFlightsWhichLastBetweenOneAndThreeHours();

    List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity();

    void changeDepartureTimeById(String id, LocalDateTime newDepartureTime);

    void incrementDurationForFlightsInParis(int minutesToAdd);

    void deleteById(String id);

    int deleteAllFromParis();

    void deleteAll();
}
