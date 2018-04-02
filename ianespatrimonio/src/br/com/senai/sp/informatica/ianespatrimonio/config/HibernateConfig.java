package br.com.senai.sp.informatica.ianespatrimonio.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ianes_tt3?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root132");
		
		return dataSource;
	}
	
	@Bean
	public Properties getHibernateProperties() {
		Properties props = new Properties();
		// Setting properties
		props.setProperty("hibernet.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return props;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setHibernateProperties(getHibernateProperties());
		
		factoryBean.setPackagesToScan("br.com.senai.sp.informatica.ianespatrimonio.models");
		
		return factoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		
		return transactionManager;
	}
	
}
