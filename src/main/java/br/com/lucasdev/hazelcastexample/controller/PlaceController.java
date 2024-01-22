package br.com.lucasdev.hazelcastexample.controller;

import br.com.lucasdev.hazelcastexample.domain.places.Place;
import br.com.lucasdev.hazelcastexample.services.PlaceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("places")
@Slf4j
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        log.info("fetching the Place with id " + id + " from DB");
        Optional<Place> place = placeService.findOne(id);
        return place.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return placeService.insert(place);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@RequestBody Place place, @PathVariable Long id) {
        return placeService.update(place, id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id) {
        placeService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
