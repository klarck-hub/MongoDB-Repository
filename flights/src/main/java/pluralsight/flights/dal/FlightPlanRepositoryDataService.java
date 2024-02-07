package pluralsight.flights.dal;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pluralsight.flights.domain.AircraftFactory;
import pluralsight.flights.domain.FlightPlan;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightPlanRepositoryDataService implements FlightPlanDataService {

    private  FlightPlanRepository repository;

    public FlightPlanRepositoryDataService(FlightPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insertInitialFlightPlans() {
        var parisToLondon = new FlightPlan(
                "Paris",
                "London",
                LocalDateTime.of(2023, 6, 1, 20, 15),
                90,
                List.of("France", "England"),
                true,
                AircraftFactory.buildBoeing737()
        );
        this.repository.insert(parisToLondon);
        var parisToNice = new FlightPlan(
                "Paris, France",
                "Nice, France",
                LocalDateTime.of(2023, 7, 3, 9, 0),
                100,
                List.of("France"),
                false,
                AircraftFactory.buildEmbraerE175()
        );

        var istanbulToPhuket = new FlightPlan(
                "Istanbul, Turkey",
                "Phuket, Thailand",
                LocalDateTime.of(2023, 12, 15, 22, 50),
                600,
                List.of("Turkey", "Iran", "Pakistan", "India", "Thailand"),
                true,
                AircraftFactory.buildAirbusA350()
        );

        var istanbulToBucharest = new FlightPlan(
                "Istanbul, Turkey",
                "Bucharest, Romania",
                LocalDateTime.of(2023, 12, 15, 21, 30),
                600,
                List.of("Turkey", "Romania"),
                true,
                AircraftFactory.buildBoeing737()
        );

        var berlinToNewYork = new FlightPlan(
                "Berlin, Germany",
                "New York, United States",
                LocalDateTime.of(2023, 9, 5, 15, 0),
                420,
                List.of("Germany", "England", "United States"),
                true,
                AircraftFactory.buildBoeing747()
        );

        var viennaToBucharest = new FlightPlan(
                "Vienna, Austria",
                "Bucharest, Romania",
                LocalDateTime.of(2023, 8, 1, 11, 30),
                75,
                List.of("Austria", "Hungary", "Romania"),
                true,
                AircraftFactory.buildBoeing737()
        );

        var flightPlans = List.of(
                parisToNice,
                viennaToBucharest,
                berlinToNewYork,
                istanbulToPhuket,
                istanbulToBucharest
        );
        this.repository.insert(flightPlans);

    }

    @Override
    public FlightPlan findById(String id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<FlightPlan> findInternationalCrossingFrance() {
        return this.repository.findInternationalCrossing("France");
    }

    @Override
    public List<FlightPlan> findFirstTwoFlightsWhichLastBetweenOneAndThreeHours() {
        return this.repository.findByFlightDurationBetween(60,180, PageRequest.of(0,2));
    }

    @Override
    public List<FlightPlan> findBoeingFlightsAndOrderBySeatCapacity() {
        return this.repository.findByAircraftModelContainsOrderByAircraftSeatCapacity("Boeing");
    }

    @Override
    public void changeDepartureTimeById(String id, LocalDateTime newDepartureTime) {

    }

    @Override
    public void incrementDurationForFlightsInParis(int minutesToAdd) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteAllFromParis() {

    }

    @Override
    public void deleteAll() {

    }
}
