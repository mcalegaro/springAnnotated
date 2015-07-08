package com.calegaro.jc.init.cfg;

import java.util.Properties;
//import org.hibernate.dialect.MySQL5Dialect;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@EnableJpaRepositories(basePackages = { "com.calegaro.jc.entity.repository" })
@EnableTransactionManagement
public class JPAConfig {

	@SuppressWarnings("unused")
	private static final String AUTO_CREATE = "create";
	private static final String AUTO_UPDATE = "update";

	@Bean
	public DataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		// dataSource.setUrl("jdbc:mysql://localhost:3306/brimidb");
		dataSource.setUser("jc2");
		dataSource.setPassword("jc2");
		dataSource.setDatabaseName("jc2db");
		dataSource.setPort(3306);
		dataSource.setServerName("localhost");
		dataSource.setCreateDatabaseIfNotExist(true);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("com.calegaro.jc.entity");
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);

		Properties jpaProterties = new Properties();
		jpaProterties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		jpaProterties.put("hibernate.format_sql", "false");
		jpaProterties.put("hibernate.show_sql", "true");
		
		jpaProterties.put("hibernate.hbm2ddl.auto", AUTO_UPDATE);

		entityManagerFactoryBean.setJpaProperties(jpaProterties);

		return entityManagerFactoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}

}