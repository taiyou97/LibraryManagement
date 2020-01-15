package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Books;
import com.app.pojos.Users;

@Repository
public class OwnerDaoImpl implements IOwnerDao {
	
	@Autowired
	SessionFactory sf;

	@Override
	public String changePassword(String email, String oldP, String newP) {
		String jpql = "select u from Users u where email = :email and passwd = :password";
		Users u = sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("email", email).setParameter("password", oldP).getSingleResult();
		u.setPasswd(newP);
		return "Password Changed";
	}

	@Override
	public String updateProfile(Users u) {
		sf.getCurrentSession().update(u);
		return "Profile Updated";
	}

	@Override
	public List<Books> getAllBooks() {
		String jpql = "select b from Books b left outer join fetch b.copies";
		return sf.getCurrentSession().createQuery(jpql, Books.class).getResultList();
	}

}
