package mk.ukim.finki.emt.airbnb.service.impl;

import mk.ukim.finki.emt.airbnb.models.Country;
import mk.ukim.finki.emt.airbnb.models.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emt.airbnb.repository.CountryRepository;
import mk.ukim.finki.emt.airbnb.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(String id) {
        return Optional.of(countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new));
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> create(String name, String continent) {
        Country country = new Country(name, continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(String id, String name, String continent) {
        Country country = countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);

        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> delete(String id) {
        Country country = countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
        countryRepository.delete(country);
        return Optional.of(country);
    }
}
