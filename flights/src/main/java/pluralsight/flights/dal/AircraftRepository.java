package pluralsight.flights.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pluralsight.flights.domain.Aircraft;

@Repository
public interface AircraftRepository extends MongoRepository<Aircraft,String> {
}
