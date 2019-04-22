package com.alphind.controller;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.alphind.model.Users;
import com.alphind.service.UserService;


@Controller
public class UserController {	
	
	public UserController()
	{
		System.out.println("usercontroller()");
	}
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest request , HttpServletResponse response, HttpSession session)
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		ModelAndView mav = new ModelAndView();
		
		List<Users> users = userService.checkUser(uname, pass);
		
		Calendar localcal = Calendar.getInstance(TimeZone.getDefault());
				
		if(users!= null && users.size() > 0)
		{
			
			System.out.println("loginID:" + users.get(0).getEmployee_id());
			session.setAttribute("userID", users.get(0).getEmployee_id());
			
			System.out.println("CurrentMonth:" + localcal.get(Calendar.MONTH));
			session.setAttribute("Month", localcal.get(Calendar.MONTH));
			
			System.out.println("CurrentYear:" + localcal.get(Calendar.YEAR));
			session.setAttribute("year", localcal.get(Calendar.YEAR));
			
			mav.addObject("user", uname);
			
			mav.setViewName("sidemenu.jsp");	
		}
		else
		{
			mav.setViewName("index.jsp");
		}
		
		return mav;
	}
	

}
