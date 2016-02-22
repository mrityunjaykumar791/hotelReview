/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mindfire.reviewhotel")
public class SpringConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * Spring MVC Framework provides the ViewResolver interface, that maps view
	 * names to actual views. when a ModelAndView instance is returned by a
	 * Controller, the view resolver will resolve the view according to the view
	 * name. The InternalResourceViewResolver(Implementation Class) maps the jsp
	 * and html files in the /WEB-INF/views folder. It allows us to set
	 * properties such as prefix or suffix to the view name to generate the
	 * final view page URL.
	 * 
	 * @return {@link viewResolver}
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/**
	 * Mapping of src\main\webapp\resources folder and all its content to a
	 * resource location value /resources/ This mapping is mainly used for
	 * accesing css and javascript file and images.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}