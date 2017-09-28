package com.nobodyiam.spring.in.action.reservation.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationClientApplication {
//  @Bean
//  CommandLineRunner runner(DiscoveryClient dc) {
//    return args -> {
//      dc.getInstances("reservation-service")
//              .forEach(si -> System.out.println(String.format(
//                      "Found %s %s:%s", si.getServiceId(), si.getHost(), si.getPort())));
//    };
//  }
//
//  /**
//   * The load balanced rest template
//   */
//  @LoadBalanced
//  @Bean
//  RestTemplate loadBalanced() {
//    return new RestTemplate();
//  }
//
//  /**
//   * The normal rest template
//   */
//  @Primary
//  @Bean
//  RestTemplate restTemplate() {
//    return new RestTemplate();
//  }

  public static void main(String[] args) {
    SpringApplication.run(ReservationClientApplication.class, args);
  }
}
