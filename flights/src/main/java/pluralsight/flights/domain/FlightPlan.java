package pluralsight.flights.domain;

import org.bson.json.JsonObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "FlightPlans")
public class FlightPlan {
    @Id
    private String id;

    @Field(name = "departure")
    @TextIndexed
    private String departureCity;

    @Field(name = "destination")
    @TextIndexed
    private String destinationCity;

    @Indexed(direction = IndexDirection.ASCENDING)
    private LocalDateTime departureDateTime;

    private int flightDuration;

    @TextIndexed
    private List<String> crossedCountries;
    private boolean isInternational;
    @DBRef
    private Aircraft aircraft;

    // Used by Spring Data MongoDB for object creation
    // See https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mapping-chapter
    protected FlightPlan(){}

    // Used inside application only
    public FlightPlan(String departureCity,
                      String destinationCity,
                      LocalDateTime departureDateTime,
                      int flightDuration,
                      List<String> crossedCountries,
                      boolean isInternational,
                      Aircraft aircraft){
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureDateTime = departureDateTime;
        this.flightDuration = flightDuration;
        this.crossedCountries = crossedCountries;
        this.isInternational = isInternational;
        this.aircraft = aircraft;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public List<String> getCrossedCountries() {
        return crossedCountries;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public String toString() {
        return "\nFlightPlan {" +
                "\n id='" + id + '\'' +
                ", \n departure='" + departureCity + '\'' +
                ", \n destination='" + destinationCity + '\'' +
                ", \n departsAt=" + departureDateTime +
                ", \n duration=" + flightDuration +
                ", \n crossedCountries=" + crossedCountries +
                ", \n isInternational=" + isInternational +
                ", \n aircraft=" + aircraft +
                "\n" +
                '}';
    }
}
