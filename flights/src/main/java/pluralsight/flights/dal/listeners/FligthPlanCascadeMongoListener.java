package pluralsight.flights.dal.listeners;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;
import pluralsight.flights.domain.FlightPlan;

@Component
public class FligthPlanCascadeMongoListener extends AbstractMongoEventListener<FlightPlan> {

    private MongoTemplate mongoTemplate;

    public FligthPlanCascadeMongoListener(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<FlightPlan> event) {
       var flightPLan = event.getSource();
       if ( flightPLan.getAircraft() != null && flightPLan.getAircraft().getId() == null){
           this.mongoTemplate.insert(flightPLan.getAircraft());
       }

    }
}
