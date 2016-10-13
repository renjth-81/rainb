package com.renjith.rainb.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

@Configuration
public class SocialConfig {

	@Autowired
	Environment env;

	@Bean
	public FacebookConnectionFactory facebookConnectionFactory() {
		return new FacebookConnectionFactory(env.getProperty("fb.app_id"), env.getProperty("fb.app_secret"));
	}

}
