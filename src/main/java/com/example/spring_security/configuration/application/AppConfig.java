package com.example.spring_security.configuration.application;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ogbozoyan
 * @date 25.05.2023
 */
@Configuration
public class AppConfig {
    @Bean(name = "patchingMapper")
    ModelMapper patchingModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setSkipNullEnabled(true)
                .setCollectionsMergeEnabled(false)
                .setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }
}
