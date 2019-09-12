package org.salesforce.koa.application.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.salesforce.koa.application.config.KOAApplicationConfig;
import org.salesforce.koa.application.entity.Account;
import org.salesforce.koa.application.entity.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Properties;

@Repository
public class KOAApplicationDAOImpl implements IKOAApplicationDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	private Properties properties;
	
	@Autowired
	public KOAApplicationDAOImpl(BasicDataSource basicDataSource, Properties namedQueries) {
		jdbcTemplate = new JdbcTemplate(basicDataSource);
		properties = namedQueries;
	}
	
 

	@Override
	public List<Account> getAllKOAAccounts() {
		System.out.println("***KOAApplicationDAOImpl****");
		//BasicDataSource cp = config.getConnectionPool();
		try {
			//jdbcTemplate = new JdbcTemplate(cp);
			RowMapper<Account> rowMapper = new AccountRowMapper();
			List<Account> accountsList = jdbcTemplate.query((String)properties.get("findKoaAccounts"),rowMapper);
			/*List<Account> accountsList = new ArrayList<Account>();
			Account acc = new Account();
			acc.setAccountId("1234");
			acc.setAccountName("abcd");
			accountsList.add(acc);*/
			System.out.println("accountsList"+accountsList);
			return accountsList;
		}
		catch(Exception ex) {
			return null;
		}
		finally{
			try {
				//cp.close();
			}
			catch(Exception ex) {
			}
			
		}
		
	}
	

}
