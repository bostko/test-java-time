package com.valentinaitken.test.configuration;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerConfiguration {

  @Bean
  public Docket allApis() {
    final ApiInfo appInfo = new ApiInfoBuilder()
        .title("Time test API")
        .version("1.0-SNAPSHOT")
        .build();
    return new Docket(SWAGGER_2)
        .groupName("Time test")
        .select()
        .paths(PathSelectors.any())
        .build()
        .apiInfo(appInfo);
  }

  @Primary
  @Bean
  public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider inMemory) {
    return () -> {
      SwaggerResource fileResource = new SwaggerResource();
      fileResource.setSwaggerVersion("2.0");
      fileResource.setLocation("/swagger.json");
      List<SwaggerResource> resources = new ArrayList<>(inMemory.get());
      resources.add(fileResource);
      return resources;
    };
  }
}
