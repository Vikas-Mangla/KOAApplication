package org.salesforce.koa.application.dao;

import java.util.List;

import org.salesforce.koa.application.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface IKOAApplicationDAO {
	
	List<Account> getAllKOAAccounts();

}
