package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {
  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            "directory_route",
            r -> r.path("/api/v1/directory/**").uri("http://directory-service:8081"))
        .route("patient_rout", r -> r.path("/api/v1/patient/**").uri("http://patient-service:8082"))
        .route(
            "appointment route",
            r -> r.path("/api/v1/appointment/**").uri("http://appointment-service:8083"))
        .route("cases_route", r -> r.path("/api/v1/case/**").uri("http://case-service:8084"))
        .build();
  }
}
