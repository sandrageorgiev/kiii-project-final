package mk.ukim.finki.emt.airbnb.web.controller;

import mk.ukim.finki.emt.airbnb.models.Accommodation;
import mk.ukim.finki.emt.airbnb.models.Country;
import mk.ukim.finki.emt.airbnb.models.Host;
import mk.ukim.finki.emt.airbnb.models.dto.AccommodationDto;
import mk.ukim.finki.emt.airbnb.models.dto.CountryDto;
import mk.ukim.finki.emt.airbnb.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://frontend:3000", "http://localhost:3000", "http://frontend.com"})
@RequestMapping("/api/country")
public class CountryController {
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    private final CountryService countryService;


    @GetMapping
    @ResponseBody
    public List<Country> listAll(){
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable String id){
        return countryService.findById(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@RequestBody CountryDto countryDto){
        return countryService.create(countryDto.getName(), countryDto.getContinent())
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable String id,
                                               @RequestBody CountryDto countryDto){
        return countryService.edit(id, countryDto.getName(), countryDto.getContinent())
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable String id){
        return countryService.delete(id)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
