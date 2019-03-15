package com.valentinaitken.test.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ModelMapperConfiguration {

  @Bean
  @Primary
  public ModelMapper modelMapper() {
    final ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration()
        .setFieldMatchingEnabled(false)
        .setFieldAccessLevel(AccessLevel.PRIVATE)
        .setMethodAccessLevel(AccessLevel.PRIVATE)
        .setSourceNamingConvention(NamingConventions.NONE)
        .setSourceNameTransformer((name, nameableType) -> name)
        .setDestinationNamingConvention(NamingConventions.NONE)
        .setDestinationNameTransformer((name, nameableType) -> name)
        .setMatchingStrategy(MatchingStrategies.STRICT);

    return modelMapper;
  }

}
