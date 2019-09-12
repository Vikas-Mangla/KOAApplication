package org.salesforce.koa.application.schedule;

import java.util.List;

import org.salesforce.koa.application.controller.KOAApplicationController;
import org.salesforce.koa.application.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KOAApplicationScheduledTasks {
	
	@Autowired
	private KOAApplicationController koaController;
	
	@Scheduled(cron = "*/15 * * * * *")
	public void scheduleTaskWithFixedRate() {
		try {
			List<Account> accList = koaController.getKOAAccounts();
			for(Account acc : accList) {
				System.out.println("***ACCOUNT LIST***"+acc.getAccountId());
				System.out.println("***ACCOUNT LIST***"+acc.getAccountName());
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
