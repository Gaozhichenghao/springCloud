package com.nobodyiam.spring.in.action.reservation.service;

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
import com.google.common.collect.ImmutableList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nobodyiam.spring.in.action.reservation.service.Dto.Reservation;

import net.minidev.json.JSONObject;
import net.sf.json.JSONArray;
@RestController
@RequestMapping("/ribbon")
public class HelloControler {

    @Autowired
    @LoadBalanced
    RestTemplate rt;
    
    private String Fallback(String name){
    	return "测试熔断效果"+name;
    }
    
    
     @GetMapping("/hi")
     @HystrixCommand(fallbackMethod="Fallback")
    public String hi(String name) {
    	 System.out.println(name+"----------------1------------------");
    	 name="这是一个测试";
    	 
    	
//     String结果集直接获取
   return rt.getForObject("http://reservation-client/ribbonClient/hello?name="+name,String.class);
     }
     
     private  List<Reservation>  getReservationNamesFallback() {
    	 List<Reservation> list=new ArrayList<>();
    	 for (int i = 0; i < 5; i++) {
    		 Reservation res=new Reservation();
    		 res.setId(i);
    		 res.setReservationName("熔断结果"+i);
    		 list.add(res);
		}
    	    return list;
    	  }
     @RequestMapping("/test")
   @HystrixCommand(fallbackMethod = "getReservationNamesFallback")
   public List<Reservation> getReservationNames() {
    	 String name="success";
    	String res= rt.getForObject("http://reservation-client/ribbonClient/helloList?name="+name,String.class);
    	    	 JSONArray jsonarray = JSONArray.fromObject(res);  
    	 @SuppressWarnings("unchecked")  
         List<Reservation> list =JSONArray.toList(jsonarray,  Reservation.class); 
    	 for (Reservation reservation : list) {
			System.out.println(reservation.getReservationName());
		}
     return  list;
   }
    
     
     public Object getReservationListFallback(){
 
		return null;
    	 
     };
     
     @RequestMapping("/testList")
     @HystrixCommand(fallbackMethod = "getReservationListFallback")
     public Object getReservationList() {
    	 String name ="success";
    		String res= rt.getForObject("http://reservation-client/ribbonClient/helloList?name="+name,String.class);
       return res;
     }
}
