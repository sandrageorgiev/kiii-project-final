package mk.ukim.finki.emt.airbnb.repository;

import mk.ukim.finki.emt.airbnb.models.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {
}
