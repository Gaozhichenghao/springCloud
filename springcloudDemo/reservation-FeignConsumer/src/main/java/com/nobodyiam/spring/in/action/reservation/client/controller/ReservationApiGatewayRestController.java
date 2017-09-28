package com.nobodyiam.spring.in.action.reservation.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nobodyiam.spring.in.action.reservation.client.service.FeignService;
@RestController
@RequestMapping("/reservations")
public class ReservationApiGatewayRestController {
  @Autowired
  FeignService feignService;

  
  @RequestMapping("/test")
  public String getResult() {
	  return feignService.sayHiFromClientOne("dddd");
  }
  

   
}
