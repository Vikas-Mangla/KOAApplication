package org.salesforce.koa.application.service;

import java.util.List;

import org.salesforce.koa.application.dao.IKOAApplicationDAO;
import org.salesforce.koa.application.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("koaApplicationService")
public class KOAApplicationServiceImpl implements IKOAApplicationService{
	
	@Autowired
	private IKOAApplicationDAO koaApplicationDAO;
	
	@Override
	public List<Account> getAllKOAAccounts() {
		System.out.println("***KOAApplicationServiceImpl***");
		List<Account> accList = koaApplicationDAO.getAllKOAAccounts();
		return accList;
	}
	

}
