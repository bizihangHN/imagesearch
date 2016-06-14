package com.bizihang.imagesearch.account.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "userGenerator")
	@GenericGenerator(name = "userGenerator", strategy = "native")
	private Integer id;

	private String username;

	private String password;

	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "id")
	private Department department;
}
