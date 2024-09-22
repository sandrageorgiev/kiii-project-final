package mk.ukim.finki.emt.airbnb.repository;

import mk.ukim.finki.emt.airbnb.models.Accommodation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends MongoRepository<Accommodation, String> {
}
