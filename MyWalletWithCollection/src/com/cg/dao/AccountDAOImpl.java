package com.cg.dao;

/**
 * AccountDAOImpl is a DAO class performing CRUD operation for Accoun
 * 
 * @author tanmpath 
 * */
import com.cg.bean.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDAOImpl implements AccountDAO{

	/*
	 *Maintain the records of all the account holders.
	 *Here mobile number act as key to retrieve and insert the records.  
	 * */
	private Map<Long, Account> accList = new HashMap<Long, Account>();
	private List<Integer> accountIDlist = new ArrayList<Integer>();
	
	/**
	 * Add the given account to the collection on the basis of the mobile number
	 * @param acc is the account to be stored
	 * @return boolean : true - if successful / false - if unsuccessful 
	 * */
	@Override
	public boolean addAccount(Account acc) {
		try {
			accList.put(acc.getMobile(), acc);
			accountIDlist.add(acc.getAid());
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}

	
	/**
	 * Update the existing account
	 * @param acc account to be updated
	 * @return boolean : true - if successful / false - if unsuccessful
	 * */
	@Override
	public boolean updateAccount(Account acc) {
		try {
			accList.put(acc.getMobile(), acc);
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}

	
	/**
	 * Delete the existing account
	 * @param acc account to be removed
	 * @return boolean : true - if successful / false - if unsuccessful
	 * */
	@Override
	public boolean deleteAccount(Account acc) {
		try {
			accList.remove(acc.getMobile());
			accountIDlist.remove(accountIDlist.indexOf(acc.getAid()));
			return true;
		}catch(NullPointerException e) {
			return false;
		}
	}

	/**
	 * Find account using mobile number as a key
	 * @param mobileNo account holder mobile number
	 * @return account that is linked to the given mobile number
	 * */
	@Override
	public Account findAccount(long mobileNo) {
		return accList.get(mobileNo);
	}
	
	
	/**
	 * Retrieve all the account from the collection
	 * @return all the accounts currently present
	 * */
	@Override
	public Map<Long, Account> getAccList() {
		return accList;
	}

	/**
	 * To find that account id already occupied or not
	 * @return boolean : true - if not occupied / false - is occupied
	 * */
	@Override
	public boolean findAccountID(Integer id) {
		return accountIDlist.contains(id);
	}
	
}
