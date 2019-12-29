package com.mhussai.studium.seminarteilnehmer.reactive;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "serminateilnehmer")
@RequiredArgsConstructor
public class SeminarteilnehmerController {

    private final SeminarteilnehmerService seminarteilnehmerService;

    @RequestMapping(method = GET)
    public Flux<Seminarteilnehmer> findAll() {
        return seminarteilnehmerService.findAll();
    }

    @RequestMapping(method = GET, path = "{id}")
    public Mono<Seminarteilnehmer> findById(@PathVariable("id") Long id) {
        return seminarteilnehmerService.findById(id);
    }

    @RequestMapping(method = GET, path = "findByMatrikelnummer/{matrikelNummer}")
    public Mono<Seminarteilnehmer> findByMatrikelnummer(@PathVariable("matrikelNummer") Long matrikelNummer) {
        return seminarteilnehmerService.findByMatrikelNummer(matrikelNummer);
    }

    @RequestMapping(method = POST)
    public Mono<ResponseEntity<?>> create(@RequestBody Seminarteilnehmer seminarteilnehmer) {
        return seminarteilnehmerService.save(seminarteilnehmer)
                .map(entity -> ResponseEntity.created(URI.create("/serminateilnehmer/" + entity.getId()))
                        .build());
    }

}