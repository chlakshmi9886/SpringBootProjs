package com.nt.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingServiceConsumerClient {

	@Autowired
	private LoadBalancerClient client;
	
	public String getBillingInfo()
	{
		//Get billing-service instance from Eureka server based LoadFactor
		ServiceInstance instance = client.choose("Billing-Service");
		//Get details from service instance
		URI uri = instance.getUri();
		
		String url = uri+"/billing/api/info";
		
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity(url, String.class);
		String responseContent = response.getBody();
		return responseContent;
		
	}
}
