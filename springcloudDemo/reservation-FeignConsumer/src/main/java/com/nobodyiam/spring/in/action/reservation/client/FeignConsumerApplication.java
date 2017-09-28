package com.nobodyiam.spring.in.action.reservation.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients(basePackages = { "com.Feign.service" })
@EnableFeignClients
public class FeignConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(FeignConsumerApplication.class, args);
  }
}
