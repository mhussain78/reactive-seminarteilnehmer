package com.mhussai.studium.seminarteilnehmer.reactive;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface SeminarteilnehmerRepository extends ReactiveCrudRepository<Seminarteilnehmer, Long> {

    @Query("SELECT * FROM Seminarteilnehmer WHERE MATRIKEL_NUMMER = :matrikelNummer")
    Mono<Seminarteilnehmer> findFirstByMatrikelNummer(Long matrikelNummer);

}