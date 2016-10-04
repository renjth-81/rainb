package com.renjith.rainb.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.renjith.rainb")
@EnableWebMvc
@Import({ DBConfig.class })
@ImportResource({ "classpath:spring-security.xml" })
public class ViewConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		// JSP view resolver
		resolvers.add(jspViewResolver());

		// JSON view resolver
		resolvers.add(jsonViewResolver());

		// exception resolver
		// resolvers.add(exceptionResolver());

		resolver.setContentNegotiationManager(manager);
		return resolver;
	}

	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver r1 = new InternalResourceViewResolver();
		r1.setPrefix("WEB-INF/pages/");
		r1.setSuffix(".jsp");
		r1.setViewClass(JstlView.class);
		return r1;
	}

	@Bean
	public ViewResolver jsonViewResolver() {
		JsonViewResolver r1 = new JsonViewResolver();
		return r1;
	}

}
