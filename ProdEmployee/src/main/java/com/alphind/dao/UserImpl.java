package com.alphind.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alphind.model.Users;


@Repository
public class UserImpl implements UserDAO{
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Users> checkUser(String uname, String pass) {
			Query query = sessionFactory.getCurrentSession().createQuery("from Users u where u.uname = :uname and u.pass = :pass");

			query.setString("uname", uname);
			query.setString("pass", pass);
			
			@SuppressWarnings("rawtypes")
			List result = query.list();
			
			System.out.println("result");
			System.out.println(result.toString());
			
			return result;
	}

	@SuppressWarnings("unchecked")
	public List<Users> listAllUsers() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}
}