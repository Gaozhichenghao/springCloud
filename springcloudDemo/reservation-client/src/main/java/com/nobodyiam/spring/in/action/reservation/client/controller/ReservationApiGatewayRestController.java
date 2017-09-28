package com.nobodyiam.spring.in.action.reservation.client.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.FluentIterable;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nobodyiam.spring.in.action.reservation.client.dto.Reservation;
@RestController
@RequestMapping("/ribbonClient")
public class ReservationApiGatewayRestController {
//  @Autowired
//  @LoadBalanced
//  private RestTemplate rt;
  

  private Collection<String> getReservationNamesFallback() {
    return Collections.emptyList();
  }
  @GetMapping("/hello")
   public String hello(String name){
	   return name;
   }
  
  
  @GetMapping("/helloList")
  public List<Reservation> helloList(String name){
	  List<Reservation> list=new ArrayList<>();
	  for (int i = 0; i <10; i++) {
		  Reservation res=new Reservation();
		  res.setId(i);
		  res.setReservationName(name+i);
		  list.add(res);
	}
	   return list;
  }
 
  
//  @RequestMapping("/test")
//  @HystrixCommand(fallbackMethod = "getReservationNamesFallback")
//  public Collection<String> getReservationNames() {
//
//    ParameterizedTypeReference<Resources<Reservation>> parameterizedTypeReference =
//            new ParameterizedTypeReference<Resources<Reservation>>() {
//            };
//
//    ResponseEntity<Resources<Reservation>> exchange = rt.exchange(
//            "http://config-server/hi",
//            HttpMethod.GET, null, parameterizedTypeReference);
////    String结果集直接获取
////    rt.getForObject("http://reservation-service/reservations",String.class);
//    return FluentIterable.from(exchange.getBody().getContent())
//            .transform(Reservation::getReservationName).toList();
//    
//   
//    
//  }
}
