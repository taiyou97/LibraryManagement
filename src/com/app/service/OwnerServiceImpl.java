package com.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOwnerDao;
import com.app.pojos.Books;
import com.app.pojos.Copies;
import com.app.pojos.Users;
import com.app.utility.BookReport;

@Service
@Transactional
public class OwnerServiceImpl implements IOwnerService {

	@Autowired
	IOwnerDao dao;
	
	@Override
	public String changePassword(String email, String oldP, String newP) {
		return dao.changePassword(email, oldP, newP);
	}

	@Override
	public String updateProfile(Users u) {
		return dao.updateProfile(u);
	}

	@Override
	public List<BookReport> bookwiseCopiesReport() {
		List<Books> books = dao.getAllBooks();
		List<BookReport> list = new ArrayList<BookReport>();
		for (Books book : books) {
				BookReport b = new BookReport(book.getId(),book.getName(),book.getCopies().size(),false, book.getCopies().size());
				for (Copies copy : book.getCopies()) {
					if(!copy.isStatus())
					{
						b.setIssued(true);
						b.setAvailable(b.getAvailable()-1);
					}
				}
				list.add(b);
		}
		return list;
	}

	@Override
	public Map<String, Integer> subjectwiseCopiesReport() {
		List<Books> books =  dao.getAllBooks();
		Map<String, Integer> map = new HashMap<>();
		for (Books book : books) {
			if(!map.containsKey(book.getSubject()))
				map.put(book.getSubject(), 1);
			else
			{
				int value = map.get(book.getSubject());
				map.put(book.getSubject(), value+1);
			}
		}
		return map;
	}
}
