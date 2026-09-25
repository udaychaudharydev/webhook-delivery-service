package com.uday.webhook;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Map;

@MicronautTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WebhookDeliveryServiceTest implements TestPropertyProvider {

    private static final PostgreSQLContainer<?> POSTGRES =
            new PostgreSQLContainer<>("postgres:18");

    @Override
    public @NonNull Map<String, String> getProperties() {
        if (!POSTGRES.isRunning()) {
            POSTGRES.start();
        }

        return Map.of(
                "datasources.default.url", POSTGRES.getJdbcUrl(),
                "datasources.default.username", POSTGRES.getUsername(),
                "datasources.default.password", POSTGRES.getPassword()
        );
    }

    @Test
    void testItWorks() {
    }

    @AfterAll
    void stopPostgres() {
        POSTGRES.stop();
    }
}