package com.mhussai.studium.seminarteilnehmer.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class SeminarteilnehmerService {

    private final SeminarteilnehmerRepository seminarteilnehmerRepository;

    public Mono<Seminarteilnehmer> findById(Long id) {
        return seminarteilnehmerRepository.findById(id);
    }

    public Mono<Seminarteilnehmer> findByMatrikelNummer(Long matrikelNummer) {
        return seminarteilnehmerRepository.findFirstByMatrikelNummer(matrikelNummer);
    }

    public Flux<Seminarteilnehmer> findAll() {
        return seminarteilnehmerRepository.findAll();
    }

    @Transactional
    public Mono<Seminarteilnehmer> save(Seminarteilnehmer seminarteilmehmer) {
        return seminarteilnehmerRepository.save(seminarteilmehmer);
    }

}