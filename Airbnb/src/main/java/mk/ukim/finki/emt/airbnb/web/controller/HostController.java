package mk.ukim.finki.emt.airbnb.web.controller;

import mk.ukim.finki.emt.airbnb.models.Accommodation;
import mk.ukim.finki.emt.airbnb.models.Host;
import mk.ukim.finki.emt.airbnb.models.dto.AccommodationDto;
import mk.ukim.finki.emt.airbnb.models.dto.HostDto;
import mk.ukim.finki.emt.airbnb.service.HostService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://frontend:3000", "http://localhost:3000", "http://frontend.com"})
@RequestMapping("/api/host")
public class HostController {
    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }


    @GetMapping
    @ResponseBody
    public List<Host> listAll(){
        return hostService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Host> findById(@PathVariable String id){
        return hostService.findById(id)
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addHost")
    public ResponseEntity<Host> addHost(@RequestBody HostDto hostDto){
        return hostService.create(hostDto.getName(), hostDto.getSurname(), hostDto.getCountryId())
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Host> editHost(@PathVariable String id,
                                                  @RequestBody HostDto hostDto){
        return hostService.edit(id, hostDto.getName(), hostDto.getSurname(), hostDto.getCountryId())
                .map(host -> ResponseEntity.ok().body(host))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Host> deleteHost(@PathVariable String id){
        return hostService.delete(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
