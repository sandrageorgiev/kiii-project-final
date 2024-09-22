package mk.ukim.finki.emt.airbnb.service;

import mk.ukim.finki.emt.airbnb.models.Accommodation;
import mk.ukim.finki.emt.airbnb.models.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    Optional<Accommodation> findById(String id);
    List<Accommodation> findAll();
    Optional<Accommodation> create(String name, Category category, String hostId, Integer numRooms);
    Optional<Accommodation> edit(String id, String name, Category category, String hostId, Integer numRooms);
    Optional<Accommodation> delete(String id);
    Optional<Accommodation> rent(String id);

}
