package mk.ukim.finki.emt.airbnb.repository;

import mk.ukim.finki.emt.airbnb.models.Host;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends MongoRepository<Host, String> {
}
