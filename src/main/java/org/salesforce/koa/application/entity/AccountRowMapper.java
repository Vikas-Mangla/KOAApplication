package org.salesforce.koa.application.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet row, int rowNum) throws SQLException {
		Account account = new Account();
		account.setAccountId(row.getString("Id"));
		account.setAccountName(row.getString("Name"));
		return account;
	}
	
}
