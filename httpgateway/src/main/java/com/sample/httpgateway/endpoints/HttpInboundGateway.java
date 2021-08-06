package com.sample.httpgateway.endpoints;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HttpInboundGateway {
	
	@Bean
	public IntegrationFlow inGate() {
		log.info("Initializing inbound gateway...");
		return IntegrationFlows.from(Http.inboundGateway("/checkInbound")
				.requestMapping(m -> m.methods(HttpMethod.POST))
				.mappedRequestHeaders("customHeader")
				.id("idInGate"))
				.enrichHeaders(h -> h.header("header", "inboundHeader"))
				.headerFilter("accept-encoding",false)
				.channel("sampleChannel")
				.get();
	}
}
