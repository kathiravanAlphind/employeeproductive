package com.alphind.dao;

import java.util.List;

import com.alphind.model.Users;

public interface UserDAO {
	
	public List<Users> checkUser(String uname , String pass);
	
	public List<Users> listAllUsers();
}
