package com.cg.dao;

import java.util.Map;

/**
 * Author: Tanmay Pathak 
 * */
import com.cg.bean.*;

public interface AccountDAO {
	public boolean addAccount(Account acc);
	public boolean updateAccount(Account acc);
	public boolean deleteAccount(Account acc);
	public Account findAccount(long mobileNo);
	public Map<Long, Account> getAccList();
	public boolean findAccountID(Integer id);
}
