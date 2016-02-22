/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.spring.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.mindfire.reviewhotel.spring.config.SpringConfiguration;

/**
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 * 
 * SpringInitializer is a class that implements WebApplicationInitializer interface.
 * We hook up to onStartup() method, to add DispatcherServlet to ServletContext.
 */
public class SpringInitializer implements WebApplicationInitializer {
 
	/**
	 * AnnotationConfigWebApplicationContext is WebApplicationContext implementation that 
	 * looks for Spring configuration in classes annotated with @Configuration annotation.
	 * Allows for registering classes one by one (specifying class names as config location) 
	 * as well as for classpath scanning (specifying base packages as config location). 
	 * @param container
	 * @exception ServletException
	 */
	@Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(SpringConfiguration.class);
        ctx.setServletContext(container);
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
      
    }
 
}
