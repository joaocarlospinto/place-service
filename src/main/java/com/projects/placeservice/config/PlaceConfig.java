package com.projects.placeservice.config;

import com.projects.placeservice.domain.PlaceRepository;
import com.projects.placeservice.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {

        return new PlaceService(placeRepository);
    }
}
