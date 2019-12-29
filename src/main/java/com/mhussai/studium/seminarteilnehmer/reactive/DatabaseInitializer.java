package com.mhussai.studium.seminarteilnehmer.reactive;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.DatabasePopulatorUtils;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseInitializer {

    private final ConnectionFactory connectionFactory;

    @EventListener(ApplicationReadyEvent.class)
    public void exercise() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("/schema.sql"));
        DatabasePopulatorUtils.execute(populator, connectionFactory);
    }

}