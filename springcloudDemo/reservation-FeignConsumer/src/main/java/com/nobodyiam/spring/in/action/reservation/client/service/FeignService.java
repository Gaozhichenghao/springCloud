package com.nobodyiam.spring.in.action.reservation.client.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//value为远程接口的全局服务名称,在FeignClient加fallback表示直接使用了断路器
@FeignClient(value = "reservation-FeignClient",fallback = HelloRemoteHystrix.class)
public interface FeignService {
	     @RequestMapping(value = "/yyyyyy/hi",method = RequestMethod.GET)
	    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
