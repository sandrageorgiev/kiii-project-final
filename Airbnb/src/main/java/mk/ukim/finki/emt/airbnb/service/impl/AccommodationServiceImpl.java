package mk.ukim.finki.emt.airbnb.service.impl;

import mk.ukim.finki.emt.airbnb.models.Accommodation;
import mk.ukim.finki.emt.airbnb.models.Host;
import mk.ukim.finki.emt.airbnb.models.enumerations.Category;
import mk.ukim.finki.emt.airbnb.models.exceptions.InvalidAccommodationIdException;
import mk.ukim.finki.emt.airbnb.models.exceptions.InvalidHostIdException;
import mk.ukim.finki.emt.airbnb.repository.AccommodationRepository;
import mk.ukim.finki.emt.airbnb.repository.HostRepository;
import mk.ukim.finki.emt.airbnb.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }


    @Override
    public Optional<Accommodation> findById(String id) {
        return Optional.of(accommodationRepository.findById(id).orElseThrow(InvalidAccommodationIdException::new));
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> create(String name, Category category, String hostId, Integer numRooms) {
        Host host = hostRepository.findById(hostId).orElseThrow(InvalidHostIdException::new);
        Accommodation accommodation = new Accommodation(name, category, host, numRooms);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> edit(String id, String name, Category category, String hostId, Integer numRooms) {
        Host host = hostRepository.findById(hostId).orElseThrow(InvalidHostIdException::new);
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(InvalidAccommodationIdException::new);

        accommodation.setName(name);
        accommodation.setCategory(category);
        accommodation.setHost(host);
        accommodation.setNumRooms(numRooms);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> delete(String id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(InvalidAccommodationIdException::new);
        accommodationRepository.delete(accommodation);
        return Optional.of(accommodation);
    }

    @Override
    public Optional<Accommodation> rent(String id) {
        Accommodation accommodation = accommodationRepository.findById(id).orElseThrow(InvalidAccommodationIdException::new);

        if(accommodation.getNumRooms() == 0){
            throw new RuntimeException("No available rooms");
        }

        accommodation.setNumRooms(accommodation.getNumRooms() - 1);
        return Optional.of(accommodationRepository.save(accommodation));
    }
}
