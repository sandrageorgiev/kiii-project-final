package mk.ukim.finki.emt.airbnb.service.impl;

import mk.ukim.finki.emt.airbnb.models.Country;
import mk.ukim.finki.emt.airbnb.models.Host;
import mk.ukim.finki.emt.airbnb.models.exceptions.InvalidCountryIdException;
import mk.ukim.finki.emt.airbnb.models.exceptions.InvalidHostIdException;
import mk.ukim.finki.emt.airbnb.repository.CountryRepository;
import mk.ukim.finki.emt.airbnb.repository.HostRepository;
import mk.ukim.finki.emt.airbnb.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;


    public HostServiceImpl(HostRepository hostRepository, CountryRepository countryRepository) {
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;

    }

    @Override
    public Optional<Host> findById(String id) {
        return Optional.of(hostRepository.findById(id).orElseThrow(InvalidHostIdException::new));
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> create(String name, String surname, String countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Host host = new Host(name, surname, country);
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> edit(String id, String name, String surname, String countryId) {
        Country country = countryRepository.findById(countryId).orElseThrow(InvalidCountryIdException::new);
        Host host = hostRepository.findById(id).orElseThrow(InvalidHostIdException::new);

        host.setName(name);
        host.setSurname(surname);
        host.setCountry(country);

        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> delete(String id) {
        Host host = hostRepository.findById(id).orElseThrow(InvalidHostIdException::new);
        hostRepository.delete(host);
        return Optional.of(host);
    }

//    @Override
//    public void refreshMaterializedView() {
//        this.hostViewRepository.refreshMaterializedView();
//    }


}
