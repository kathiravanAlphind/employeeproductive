package com.alphind.dao;

import java.util.List;

import com.alphind.model.*;

public interface EmployeeDAO {
    
    public List<Employee> getAllEmployees();
    
    // home.jsp - get TL's projects and employees
    public List<Projects> getProjects(int tlid);
    
    // get all projects by week
    public List<Projects> getProjects(String date);
    
    // get all projects and productive hours by TL and week
    public List<Projects> getProjects(int tlid, String date, List<Projects> allProjects);
 
    public List<Employee> getEmployees(int projectid, int tlid, String date);
    
    public void insertHours(int tlid, int employeeid, int projectid, String date, String prod_hours);
    
    public List<Week> getWeekList(int month, int year);
    
    public List<Employee> getTls();
}
