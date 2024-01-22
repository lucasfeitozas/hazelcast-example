package br.com.lucasdev.hazelcastexample.repository;

import br.com.lucasdev.hazelcastexample.domain.places.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
}
