package com.bizihang.imagesearch.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bizihang.imagesearch.account.dao.IAccountDao;
import com.bizihang.imagesearch.account.entity.Account;
import com.bizihang.imagesearch.account.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	@Qualifier("accountDao")
	private IAccountDao accountDao;

	@Override
	public void save(Account account) {
		accountDao.save(account);
	}
}
