package br.com.lucasdev.hazelcastexample.services;

import br.com.lucasdev.hazelcastexample.domain.places.Place;
import br.com.lucasdev.hazelcastexample.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository repository;

    public List<Place> findAll() {
        return repository.findAll();
    }

    @Cacheable(value = "places", key = "#id")
    public Optional<Place> findOne(Long id) {

        return repository.findById(id);
    }

    @CachePut(value = "places", key = "#place.id")
    public Place insert(Place place) {
        return repository.save(place);
    }

    @CachePut(value = "places", key = "#id")
    public Place update(Place place, Long id) {
        Place placeToBeUpdated = repository.findById(id).orElseThrow(() -> new RuntimeException("Place Not Found!"));

        if (StringUtils.hasText(place.getName())) placeToBeUpdated.setName(place.getName());
        if (StringUtils.hasText(place.getLatitude())) placeToBeUpdated.setLatitude(place.getLatitude());
        if (StringUtils.hasText(place.getLongitude())) placeToBeUpdated.setLongitude(place.getLongitude());
        if (StringUtils.hasText(place.getAddress())) placeToBeUpdated.setAddress(place.getAddress());

        return repository.save(placeToBeUpdated);
    }

    @CacheEvict(value = "places", allEntries=true)
    public void delete(Long id) {
        repository.deleteById(id);
        log.info("Removed Movie with id: {}", id);

    }
}
