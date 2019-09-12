package org.salesforce.koa.application.controller;

import java.util.List;

import org.salesforce.koa.application.entity.Account;
import org.salesforce.koa.application.service.IKOAApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class KOAApplicationController {
	
	@Autowired
	private IKOAApplicationService koaApplicationService;
	  
	public List<Account> getKOAAccounts() {
		System.out.println("****KOAApplicationController****"+koaApplicationService);
		List<Account> accountList = koaApplicationService.getAllKOAAccounts();
		return accountList;
	}

}
