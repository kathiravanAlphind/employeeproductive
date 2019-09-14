package com.alphind.controller;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.alphind.model.*;
import com.alphind.service.*;


@Controller
public class EmployeeController {
	
	//private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	public EmployeeController() {
		System.out.println("employeeController");
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	private List<Projects> listProjects;
	
	@SuppressWarnings("unused")
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unused")
	@Autowired
	private ProjectService proService;
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView listAllEmployee(ModelAndView model, HttpSession session,HttpServletRequest request) {
		
		//System.out.println(request.getParameter("month"));
		
		int tlId = (Integer) session.getAttribute("userID");
		
		this.listProjects = employeeService.getProjects(tlId);
		
		model.addObject("listProject", listProjects);
		
		model.setViewName("home.jsp");
		
		return model;
	}
	
	@RequestMapping(value = "/submit" , method = RequestMethod.GET)
	public ModelAndView submit(ModelAndView model, HttpSession session, HttpServletRequest request) 
	{
		String date = getMonday();
		
		int tlId = (Integer) session.getAttribute("userID");
		for (Projects p : this.listProjects) {
			
			for (Employee e : p.getEmployees()) {
				
				String prod = request.getParameter(e.getHtmlname());
				
				employeeService.insertHours(tlId, p.getId(), e.getId(), date, prod == "" ? "0" : prod);
				
				//System.out.println(e.getHtmlname());
				//System.out.println(request.getParameter(e.getHtmlname()));
			}
		}
		
		model.setViewName("redirect:/dashboard");
		return model;
	}
	
	public String getMonday()
	{
		LocalDate localDate = LocalDate.now();
		if(localDate.getDayOfWeek() != DayOfWeek.MONDAY)
		{
			long minus = Long.valueOf(localDate.getDayOfWeek().getValue()-1);
			System.out.println(minus);
			localDate = localDate.minusDays(minus);
			System.out.println(localDate.toString());
		}
		return localDate.toString();
	}
	
	@RequestMapping(value = "/dashboard" , method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView list(ModelAndView model, HttpSession session, HttpServletRequest request)
	{
		int month = (Integer) session.getAttribute("Month");
		
		System.out.println(month);
		
		int year = (Integer) session.getAttribute("year");
		
		System.out.println(year);
		
		String monString = Integer.toString(month);
		
		String dateString = monString.length() == 1 ? "0"+monString : monString;
		
		dateString = Integer.toString(year) + "-" + dateString;
		
		System.out.println(dateString);
		
		List<Week> week_list = employeeService.getWeekList(month, year);
		
		List<Employee> team_leads = null;
		
		for(Week w : week_list)
		{
			w.setProlist(employeeService.getProjects(w.getDate().toString()));
			
			team_leads = employeeService.getTls();
			
			//int i = 0;
			
			for(Employee tl:team_leads)
			{
				//System.out.println(w.getProlist().toString());
				tl.setProjects(employeeService.getProjects(tl.getId(), w.getDate().toString(), w.getProlist()));
				/*System.out.println("Check While Setting");
				for (int j = 0; j<i+1; j++) 
				{
					for (Projects p : team_leads.get(j).getProjects()) 
					{
						System.out.println(team_leads.get(j).getFname()+ ":" + p.getPname() + ": " + p.getProd_hours());
					}
				}
				i++;
				*/
			}
			w.setTl_list(team_leads);
		}
		/*
		//DEBUGGING LOOP
		for (Week w : week_list) {
			for (Employee tl : w.getTl_list()) {
				System.out.println(tl.getFname());
				System.out.println("Controller ProdHours Check");
				for (Projects p : tl.getProjects()) {
					System.out.println(p.getPname());
					System.out.println(p.getProd_hours());
				}
			}
		}
		*/
		model.addObject("listOfWeeks", week_list);
		
		model.addObject("TeamLeader", team_leads);
		
		model.addObject("date", dateString);
		
		model.setViewName("form.jsp");
		
		return model;
	}
	
	
	@RequestMapping(value = "/select" , method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView select(ModelAndView model, HttpSession session, HttpServletRequest request)
	{
		String date = request.getParameter("date");
		
		System.out.println(date);
		
		String[] dateList = date.split("-");
		
		int month =Integer.parseInt(dateList[1]);
		
		int year = Integer.parseInt(dateList[0]);
		
		session.setAttribute("Month", month);
		
		session.setAttribute("year", year);
		
		model.setViewName("forward:/dashboard");
		
		return model;
	}
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView logout(HttpSession session, ModelAndView model)
	{
		session.invalidate();
		model.setViewName("index.jsp");
		return model;
		
	}
}