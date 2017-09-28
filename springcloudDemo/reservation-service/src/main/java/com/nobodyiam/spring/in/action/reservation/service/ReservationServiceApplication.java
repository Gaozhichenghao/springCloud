package com.nobodyiam.spring.in.action.reservation.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import com.google.common.base.Splitter;
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {
//  @Bean
//  CommandLineRunner runner(DiscoveryClient dc) {
//    return args -> {
//      dc.getInstances("reservation-service")
//              .forEach(si -> System.out.println(String.format(
//                      "Found %s %s:%s", si.getServiceId(), si.getHost(), si.getPort())));
//    };
//  }

/**
* The load balanced rest template
*/
@LoadBalanced
@Bean
RestTemplate loadBalanced() {
 return new RestTemplate();
}

/**
* The normal rest template
*/
@Primary
@Bean
RestTemplate restTemplate() {
 return new RestTemplate();
}
  
  
  
  public static void main(String[] args) {
    new SpringApplicationBuilder(ReservationServiceApplication.class)
            .run(args);
  }
}
