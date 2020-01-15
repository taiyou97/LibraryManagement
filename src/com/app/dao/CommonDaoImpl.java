package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Users;

@Repository
public class CommonDaoImpl implements ICommonDao {
	
	@Autowired
	SessionFactory sf;
	
	public CommonDaoImpl() {
		System.out.println("CommonDaoImpl()");
	}

	@Override
	public Users login(String email, String password) {
		System.out.println("CommonDaoImpl login " + email + password);
		String jpql = "select u from Users u where email = :email and passwd = :passwd";
		return sf.getCurrentSession().createQuery(jpql, Users.class).setParameter("email", email).
				setParameter("passwd", password).getSingleResult();
	}

	@Override
	public String registerUser(Users u) {
		sf.getCurrentSession().persist(u);
		return "User Registered";
	}

}
