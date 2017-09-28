package com.Feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/yyyyyy")
public class ReservationApiGatewayRestController {
  @RequestMapping(value = "/hi",method = RequestMethod.GET)
  public String getResult(@RequestParam(value = "name") String name) {
	  System.out.println("=============================================================");
	  return  "Success";
  }
  

   
}
