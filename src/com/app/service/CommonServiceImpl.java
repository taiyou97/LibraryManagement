package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICommonDao;
import com.app.pojos.Users;

@Service
@Transactional
public class CommonServiceImpl implements ICommonService {

	@Autowired
	ICommonDao dao;
	
	@Override
	public Users login(String email, String password) {
		System.out.println("CommonServiceImpl() login");
		return dao.login(email, password);
	}

	@Override
	public String registerUser(Users u) {
		return dao.registerUser(u);
	}

}
