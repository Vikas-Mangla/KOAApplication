package org.salesforce.koa.application;

import java.util.Calendar;

import javax.sql.DataSource;

import org.salesforce.koa.application.schedule.KOAApplicationScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KOAApplication implements ApplicationRunner{

	private static final Logger logger = LoggerFactory.getLogger(KOAApplication.class);
	
	public static void main(String[] args) {
		
		SpringApplication.run(KOAApplication.class, args);
	}
	
	@Autowired
    private DataSource dataSource;
	
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Hello World from Application Runner");
		logger.info("Current time is :: " + Calendar.getInstance().getTime());
		try {
			System.out.println("Connection Polling datasource : "+ dataSource);  // check connection pooling
			//applicationScheduledTasks.scheduleTaskWithFixedRate();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
