package com.nobodyiam.spring.in.action.reservation.client.service;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements FeignService{

	@Override
	public String sayHiFromClientOne(String name) {
		return "fail";
	}

}