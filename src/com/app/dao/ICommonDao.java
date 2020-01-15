package com.app.dao;

import com.app.pojos.Users;

public interface ICommonDao {
	public Users login(String email, String password);
	public String registerUser(Users u);
}
