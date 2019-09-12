package org.salesforce.koa.application.config;

import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class KOAApplicationConfig {

	@Bean
	Properties namedQueries() throws IOException {
		System.out.print("*******************SETTING NAMED QUERIES************************");
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/koaQueries.xml"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	@Bean
	BasicDataSource getConnectionPool() {
		//BasicDataSource connectionPool = new BasicDataSource();
		try {
			System.out.print("*******************SETTING BasicDataSource************************");
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			System.out.println("********dbUri**********"+dbUri);
	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        System.out.println("********username**********"+username);
	        System.out.println("********password**********"+password);
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
			System.out.println("********dbUrl**********"+dbUrl);
	        BasicDataSource basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUsername(username);
	        basicDataSource.setPassword(password);
	        return basicDataSource;
		} catch (Exception ex) {

		} finally {
			try {
				// connectionPool.close();
			} catch (Exception ex) {
			}

		}
		return null;
	}

}
