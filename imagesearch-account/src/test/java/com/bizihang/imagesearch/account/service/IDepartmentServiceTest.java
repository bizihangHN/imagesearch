package com.bizihang.imagesearch.account.service;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bizihang.imagesearch.account.entity.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class IDepartmentServiceTest {

	@Autowired
	private DataSource dataSource;

	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;

	@Test
	public void testDataSource() {
		System.out.println("datasource---->" + dataSource.toString());
		Assert.assertNotNull(dataSource);
	}

	@Test
	public void testSave() {
		Department department = new Department();
		department.setName("bizihang");
		departmentService.save(department);
	}

}
