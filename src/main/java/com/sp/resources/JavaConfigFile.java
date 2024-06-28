package com.sp.resources;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sp.dao.AccountDao;
import com.sp.dao.AccountDaoImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.sp")
public class JavaConfigFile 
{
	@Bean
	public DriverManagerDataSource dmDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		
		    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		    dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
		    dataSource.setUsername("root");
		    dataSource.setPassword("Rooh@#2001"); // Make sure this password is correct
		    return dataSource;
		
		
	}
	
	@Bean
	public LocalSessionFactoryBean mySessionFactory()
	{
		LocalSessionFactoryBean mySessionFactory = new LocalSessionFactoryBean();
		
		mySessionFactory.setDataSource(dmDataSource());
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.format_sql", "true");
		mySessionFactory.setHibernateProperties(hibernateProperties);
		
		mySessionFactory.setPackagesToScan("com.sp.beans");
		
		return mySessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager()
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(mySessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public HibernateTemplate myHibernateTemplate()
	{
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(mySessionFactory().getObject());
		hibernateTemplate.setCheckWriteOperations(false);
		//System.out.println("hibernateTemplate.setSessionFactory(mySessionFactory()"+hibernateTemplate.setSessionFactory(mySessionFactory());
		System.out.println("hibernateTemplate" +hibernateTemplate);
		return hibernateTemplate;
	}
	
	@Bean
	public AccountDao stdDaoImplBean()
	{
		AccountDaoImpl stdDaoImpl = new AccountDaoImpl();
		stdDaoImpl.setHibernatetemp(myHibernateTemplate());
		return stdDaoImpl;
	}
}
