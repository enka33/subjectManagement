package com.mec.baseconfig;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class RepositoryConfig {
	@Bean
	public DataSource configDatabasePool() {
		return new ComboPooledDataSource();
	}
	
	@Bean
	public LocalSessionFactoryBean configSessionFactory(DataSource dataSource) {
		System.out.println("DataBase ===============================");
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setPackagesToScan("com.mec.model");
		return localSessionFactoryBean;
	}
	
	@Bean
	public PlatformTransactionManager configTransactionManager(SessionFactory sessionFactory) {
		System.out.println("DataBase ===============================");
		return new HibernateTransactionManager(sessionFactory);
	}
}
