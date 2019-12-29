package com.mhussai.studium.seminarteilnehmer.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

@Configuration
public class SeminarFunctionalEndpointConfiguration {

    @Bean
    RouterFunction<ServerResponse> seminare(SeminarteilnehmerService seminarteilnehmerService) {
        return RouterFunctions.route().GET("/seminare", request -> {
            Flux<Seminar> seminare = seminarteilnehmerService.findAll().map(seminarteilnehmer -> new Seminar(seminarteilnehmer.getSeminar()));
            return ServerResponse.ok().body(seminare, Seminar.class);
        }).build();
    }

}