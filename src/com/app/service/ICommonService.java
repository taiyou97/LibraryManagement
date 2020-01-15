package com.app.service;

import com.app.pojos.Users;

public interface ICommonService {
	public Users login(String email, String password);
	public String registerUser(Users u);
}
