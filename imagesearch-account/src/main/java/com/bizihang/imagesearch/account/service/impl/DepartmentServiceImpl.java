package com.bizihang.imagesearch.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bizihang.imagesearch.account.dao.IDepartmentDao;
import com.bizihang.imagesearch.account.entity.Department;
import com.bizihang.imagesearch.account.service.IDepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	@Qualifier("departmentDao")
	private IDepartmentDao departmentDao;

	@Override
	public void save(Department department) {
		System.out.println("----->");
		departmentDao.save(department);
	}
}
