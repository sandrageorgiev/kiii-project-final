package mk.ukim.finki.emt.airbnb.web.controller;
import mk.ukim.finki.emt.airbnb.models.Accommodation;
import mk.ukim.finki.emt.airbnb.models.Accommodation;
import mk.ukim.finki.emt.airbnb.models.dto.AccommodationDto;
import mk.ukim.finki.emt.airbnb.models.enumerations.Category;
import mk.ukim.finki.emt.airbnb.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://frontend:3000", "http://localhost:3000", "http://frontend.com"})
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }


    @GetMapping
    @ResponseBody
    public List<Accommodation> listAll(){
        return accommodationService.findAll();
    }

    @GetMapping("/categories")
    public List<Category> listCategories(){
        return List.of(Category.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable String id){
        return accommodationService.findById(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addAccommodation")
    public ResponseEntity<Accommodation> addAccommodation(@RequestBody AccommodationDto accommodationDto){
        return accommodationService.create(accommodationDto.getName(), accommodationDto.getCategory(), accommodationDto.getHostId(), accommodationDto.getNumRooms())
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Accommodation> editAccommodation(@PathVariable String id,
                                                           @RequestBody AccommodationDto accommodationDto){
        return accommodationService.edit(id, accommodationDto.getName(), accommodationDto.getCategory(), accommodationDto.getHostId(), accommodationDto.getNumRooms())
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
     }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Accommodation> deleteAccommodation(@PathVariable String id){
        return accommodationService.delete(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<Accommodation> rentAccommodation(@PathVariable String id){
        return accommodationService.rent(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
