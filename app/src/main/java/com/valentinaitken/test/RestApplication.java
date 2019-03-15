package com.valentinaitken.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.valentinaitken.test")
@EntityScan(basePackages = "com.valentinaitken.test")
@EnableJpaRepositories(basePackages = "com.valentinaitken.test")
@EnableTransactionManagement
@EnableSwagger2
public class RestApplication {
  protected RestApplication() {
  }

  public static void run(final Class<?> applicationClass, final String[] args) {
    final SpringApplication springApplication = new SpringApplication(applicationClass);
    springApplication.run(args);
  }

  public static void main(final String[] args) {
    run(RestApplication.class, args);
  }
}
