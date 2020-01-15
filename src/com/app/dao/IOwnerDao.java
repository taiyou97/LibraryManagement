package com.app.dao;

import java.util.List;

import com.app.pojos.Books;
import com.app.pojos.Users;

public interface IOwnerDao {
	public String changePassword(String email, String oldP, String newP);
	public String updateProfile(Users u);
	public List<Books> getAllBooks();
}
