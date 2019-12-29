package com.mhussai.studium.seminarteilnehmer.reactive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@Import(SeminarFunctionalEndpointConfiguration.class)
@WebFluxTest
class ReactiveSeminarteilnehmerApplicationTests {

    @Autowired
    private WebTestClient client;

    @MockBean
    private SeminarteilnehmerService seminarteilnehmerService;

    @BeforeEach
    public void initialize() {
        var seminarteilnehmer = Flux.just(createSeminarteilnehmer(1L), createSeminarteilnehmer(2L));
        Mockito.when(seminarteilnehmerService.findAll()).thenReturn(seminarteilnehmer);
    }

    @Test
    public void testGetSeminarteilnemer() {
        this.client.get().uri("/serminateilnehmer")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.[0].id").isEqualTo("1")
                .jsonPath("$.[0].name").isEqualTo("Name_1")
                .jsonPath("$.[1].id").isEqualTo("2")
                .jsonPath("$.[1].name").isEqualTo("Name_2");
    }

    @Test
    public void testGetSeminare() {
        this.client.get().uri("/seminare")
                .accept(MediaType.APPLICATION_JSON)
                .exchange().expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.[0].name").isEqualTo("Seminar_1")
                .jsonPath("$.[1].name").isEqualTo("Seminar_2");
    }

    private Seminarteilnehmer createSeminarteilnehmer(Long id) {
        Seminarteilnehmer seminarteilnehmer = new Seminarteilnehmer();
        seminarteilnehmer.setId(id);
        seminarteilnehmer.setName("Name_" + id);
        seminarteilnehmer.setEmail("name_" + id + "@mail.com");
        seminarteilnehmer.setMatrikelNummer(id);
        seminarteilnehmer.setSeminar("Seminar_" + id);
        return seminarteilnehmer;
    }

}