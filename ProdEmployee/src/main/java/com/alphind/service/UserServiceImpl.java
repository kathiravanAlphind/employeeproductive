package com.alphind.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphind.dao.UserDAO;
import com.alphind.model.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userdao;

	public List<Users> checkUser(String uname, String pass) {
		// TODO Auto-generated method stub
		return userdao.checkUser(uname, pass);
	}

	public List<Users> listAllUsers() {
		// TODO Auto-generated method stub
		return userdao.listAllUsers();
	}


}
