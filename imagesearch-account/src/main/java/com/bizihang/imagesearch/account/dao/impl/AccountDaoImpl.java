package com.bizihang.imagesearch.account.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizihang.imagesearch.account.dao.IAccountDao;
import com.bizihang.imagesearch.account.entity.Account;

@Repository("accountDao")
public class AccountDaoImpl extends BaseDao<Account, Integer> implements IAccountDao {
	
}
