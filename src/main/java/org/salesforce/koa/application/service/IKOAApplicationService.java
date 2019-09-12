package org.salesforce.koa.application.service;

import java.util.List;

import org.salesforce.koa.application.entity.Account;
import org.springframework.stereotype.Service;

public interface IKOAApplicationService {

	List<Account> getAllKOAAccounts();
	
}
