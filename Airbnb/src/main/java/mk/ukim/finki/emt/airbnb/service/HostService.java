package mk.ukim.finki.emt.airbnb.service;

import mk.ukim.finki.emt.airbnb.models.Country;
import mk.ukim.finki.emt.airbnb.models.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    Optional<Host> findById(String id);
    List<Host> findAll();
    Optional<Host> create(String name, String surname, String countryId);
    Optional<Host> edit(String id, String name, String surname, String countryid);
    Optional<Host> delete(String id);

//    void refreshMaterializedView();
}
