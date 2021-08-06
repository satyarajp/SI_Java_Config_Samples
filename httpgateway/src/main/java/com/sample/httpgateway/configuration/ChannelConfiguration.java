package com.sample.httpgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;

@Configuration
public class ChannelConfiguration {

	@Bean
	public DirectChannel sampleChannel() {
		return new DirectChannel();
	}
}
