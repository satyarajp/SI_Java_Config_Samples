package com.sample.httpgateway.endpoints;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.stereotype.Component;

import com.sample.httpgateway.model.CatFact;


@Component
public class HttpOutboundGateway {
	@Bean
	public IntegrationFlow outGate(){
		return IntegrationFlows.from("sampleChannel")
				.handle(Http.outboundGateway("https://catfact.ninja/fact")
				.httpMethod(HttpMethod.GET)
				.expectedResponseType(CatFact.class))
				.get(); // replace '.get()' instead of 'logAndReply()' if printing in log is to be avoided 
	}
}
