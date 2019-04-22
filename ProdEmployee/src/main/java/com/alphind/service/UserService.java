package com.alphind.service;

import java.util.List;

import com.alphind.model.Users;

public interface UserService {
	public List<Users> checkUser(String uname , String pass);
	
	public List<Users> listAllUsers();
	
	
}
