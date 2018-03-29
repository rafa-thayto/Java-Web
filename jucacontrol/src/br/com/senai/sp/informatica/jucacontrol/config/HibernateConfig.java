package br.com.senai.sp.informatica.jucacontrol.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	/**
	 * Cria um objeto com as informacoes de conexao com o banco de dados
	 * para ser utilizado pelo Hibernate
	 * @return
	 */
	@Bean // Uma forma de determinar uma classe para ser inejtada pelo String
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/jucacontrol_tt3?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("root132");
		
		return dataSource;
	}
	
	public Properties getHibernateProperties() {
		Properties props = new Properties();
		// Mostra os SQL disparados pelo Hibernate
		props.setProperty("hibernate.show_sql", "true");
		
		// Depois será explicado
		/*
		 * create: Dropa e recria as tabelas sempre
		 * update: Realiza um alter table somente quando um campo é adicionado/removido
		 * validate: Aplicação está OK. Não faz nenhuma alteração no banco
		 */
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		
		// Determina para o Hibernate que será utilizado o MySQL como dialeto
		// Dialect é a classe que realiza as traduções de SQL das operações do banco de dados 
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return props;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(getDataSource());
		factoryBean.setHibernateProperties(getHibernateProperties());
		
		// Define em qual pacote se encontram os Models da aplicação para que o hibernate possa mapea-los
		factoryBean.setPackagesToScan("br.com.senai.sp.informatica.jucacontrol.models");
		
		return factoryBean;
	}
	
}
