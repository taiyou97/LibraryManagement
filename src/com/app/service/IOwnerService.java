package com.app.service;

import java.util.List;
import java.util.Map;
import com.app.pojos.Users;
import com.app.utility.BookReport;

public interface IOwnerService {
	public String changePassword(String email, String oldP, String newP);
	public String updateProfile(Users u);
	public List<BookReport> bookwiseCopiesReport();
	public Map<String, Integer> subjectwiseCopiesReport();
}
