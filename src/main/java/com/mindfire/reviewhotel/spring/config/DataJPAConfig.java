/*
 * Copyright (c) Mindfire Solutions. 
 */
package com.mindfire.reviewhotel.spring.config;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DataJPAConfig Class is Used For Configuration of Spring DataJPA.
 * @author mrityunjay kumar
 * @version 1.0
 * @since 18-02-2016 
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.mindfire.reviewhotel.web.repository")
@PropertySource("classpath:config.properties")
@PropertySource(name = "hibernate", value = "classpath:hibernate.properties")
public class DataJPAConfig {

	@Autowired
	private Environment env;

	@Autowired
	private ConfigurableEnvironment configurableEnvironment;

	/**
	 * Entity manager definition.
	 * Create a new LocalContainerEntityManagerFactoryBean object.
	 * We need to create this object because it creates the JPA EntityManagerFactory.
	 * @return LocalContainerEntityManagerFactoryBean object.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan("com.mindfire.reviewhotel.web.domain");
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties());
		return em;
	}

	/**
	 * Additional hibernate properties loaded from external properties file.
	 */
	private Properties additionalProperties() {
		return (Properties) configurableEnvironment.getPropertySources()
				.get("hibernate").getSource();
	}

	/**
	 * Configures the DataSource. Using Tomcat jdbc pool DataSource. The
	 * connection pool settings should be configured here.
	 * 
	 * @return {@link DataSource}
	 */
	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName(env.getProperty("database.driver"));
		dataSource.setUrl(env.getProperty("database.url"));
		dataSource.setUsername(env.getProperty("database.user"));
		dataSource.setPassword(env.getProperty("database.password"));
		return dataSource;
	}

	/**
	 * Creates the the JpaTransactionManager instance.
	 * Configure the entity manager factory whose transactions are managed by
	 * the created JpaTransactionManager object.
	 * @return JpaTransactionManager Object.
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	/**
	 * Translates native resource exceptions to Spring's DataAccessException hierarchy
	 * @return
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}