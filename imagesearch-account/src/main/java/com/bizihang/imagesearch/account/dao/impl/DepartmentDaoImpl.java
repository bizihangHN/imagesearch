package com.bizihang.imagesearch.account.dao.impl;

import org.springframework.stereotype.Repository;

import com.bizihang.imagesearch.account.dao.IDepartmentDao;
import com.bizihang.imagesearch.account.entity.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDao<Department, Integer> implements IDepartmentDao {

}
