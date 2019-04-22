package com.alphind.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alphind.dao.*;
import com.alphind.model.*;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}
	
	public List<Projects> getProjects(int tlid) {
		return employeeDAO.getProjects(tlid);
	}
	
	public List<Projects> getProjects(int tlid, String date, List<Projects> allProjects)
	{
		return employeeDAO.getProjects(tlid, date, allProjects);
		/*
		for (Projects p : employeeDAO.getProjects(tlid, date, allProjects)) {
			System.out.println("Service ProdHours Check");
			System.out.println(p.getPname());
			System.out.println(p.getProd_hours());
		}
		return new ArrayList<Projects>();
		*/
	}

	public List<Employee> getEmployees(int projectid, int tlid, String date) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees(projectid,tlid, date);
	}

	public void insertHours(int tlid, int employeeid, int projectid, String date, String prod_hours) {
		// TODO Auto-generated method stub
		employeeDAO.insertHours(tlid, projectid, employeeid, date, prod_hours);
	}
	
	public List<Week> getWeekList(int month, int year)
	{
		return employeeDAO.getWeekList(month, year);
	}
	
	public List<Employee> getTls()
	{
		return employeeDAO.getTls();
	}

	public List<Projects> getProjects(String date) {
		// TODO Auto-generated method stub
		return employeeDAO.getProjects(date);
	}
	
}
