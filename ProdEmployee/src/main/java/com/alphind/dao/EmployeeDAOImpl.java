package com.alphind.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.alphind.model.Employee;
import com.alphind.model.Projects;
import com.alphind.model.Week;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@SuppressWarnings({ "unchecked" })
	public List<Projects> getProjects(int tlid) {
		// get TL's projects
		String projectQuery = "select p.id, p.pname, employees_projects.prod_hours from projects p inner join employees_projects on p.id=employees_projects.project_id where `tl_id` = :tlid";

		SQLQuery projectsQuery = sessionFactory.getCurrentSession().createSQLQuery(projectQuery);

		projectsQuery.setParameter("tlid", tlid);
		
		//projectsQuery.setParameter("date", date);

		List<Object[]> results = projectsQuery.list();

		List<Integer> pList = new ArrayList<Integer>();

		Projects project;

		List<Projects> projects = new ArrayList<Projects>();
		for (Object[] row : results) {

			Integer pid = (Integer) row[0];

			if(!pList.contains(pid))
			{
				project = new Projects();
				System.out.println(pList.toString());

				project.setId(pid);
				project.setPname((String) row[1]);
				project.setEmployees(getEmployees(project.getId(), tlid, null));

				projects.add(project);
				pList.add(pid);
			}

		}

		//System.out.println("projects:" + projects.toString());

		return projects;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Projects> getProjects(int tlid, String date, List<Projects> allProjects) {
		
		List<Projects> project = new ArrayList<Projects>();
		
		for(int i = 0 ; i < allProjects.size(); i++)
		{
			String projectQuery = "select employees_projects.prod_hours from employees_projects inner join projects p on employees_projects.project_id = p.id where tl_id = :tlid  and employees_projects.date = :date and employees_projects.project_id=:proid";
			
			SQLQuery pquery = sessionFactory.getCurrentSession().createSQLQuery(projectQuery);
			
			System.out.println(tlid);
			
			pquery.setParameter("tlid", tlid);
			
			System.out.println(date);
			
			pquery.setParameter("date", date);
			
			System.out.println(allProjects.get(i).getId());
			
			pquery.setParameter("proid", allProjects.get(i).getId());

			List<Float> rows = pquery.list();
			
			Float total = new Float(0);
			
			for(Float row: rows)
			{
				total = Float.sum(total.floatValue(), row);
			}
			//allProjects.get(i).setProd_hours(total.floatValue());
			project.add(new Projects(allProjects.get(i).getId(), allProjects.get(i).getPname(), total.floatValue()));
			//System.out.println("All project" + allProjects.get(i).getPname());
			//System.out.println("Was ph set?" + allProjects.get(i).getProd_hours());
			}
		
		return project;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Projects> getProjects(String date) {
		List<Projects> projects = new ArrayList<Projects>();
		// get TL's projects
		String projectQuery = "select distinct p.id, p.pname from projects p inner join employees_projects on p.id=employees_projects.project_id where date = :date";
		
		SQLQuery projectsquery = sessionFactory.getCurrentSession().createSQLQuery(projectQuery);
		
		projectsquery.setParameter("date", date);
		
		List<Object[]> result = projectsquery.list();
		
		Projects project;
		
		for(Object[] res: result)
		{
			project = new Projects();
			
			project.setId((Integer) res[0]);
			project.setPname((String) res[1] );
			//project.setEmployees(getEmployees(project.getId(), date));
			
			projects.add(project);
			
		}
		return projects;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Employee> getEmployees(int projectid, int tlid, String date) {
		// TODO Auto-generated method stub

		// get Employee's for TL's projects
		String sql; SQLQuery query; 

		sql = "select e.id, e.fname, e.lname, employees_projects.prod_hours from employees e inner join employees_projects on e.id=employees_projects.employee_id where employees_projects.project_id= :pid and employees_projects.tl_id = :tlid";

		if(date!=null)
		{
			sql += " and date = ':date'";
		}

		query = sessionFactory.getCurrentSession().createSQLQuery(sql);

		query.setParameter("pid", projectid);// should be p.getId()
		
		query.setParameter("tlid", tlid);

		if(date != null)
		{
			query.setParameter("date", date);
		}

		//System.out.println(query.getQueryString());

		List<Object[]> results = query.list();

		Employee user;

		List<Integer> idList = new ArrayList<Integer>();

		List<Employee> users = new ArrayList<Employee>();
		for (Object[] row : results) {
			Integer id = (Integer) row[0];
			//System.out.println(idList.toString());
			//System.out.println(idList.contains(id));
			if(!idList.contains(id))
			{
				user = new Employee();
				user.setId(id);
				user.setUname((String) row[1]);
				user.setLname((String) row[2]);

				users.add(user);
				idList.add(id);
			}
		}
		//System.out.println("result " + projectid + ": " + users.toString());

		return users;
	}

	@SuppressWarnings("unused")
	public void insertHours(int tlid, int employeeid, int projectid, String date, String prod_hours)
	{
		SQLQuery query;

		String sql = "INSERT INTO `employees_projects` (`tl_id`, `employee_id`,`project_id`, `date`, `prod_hours`) VALUES (:tlid, :eid, :pid, :date, :ph)";

		query = sessionFactory.getCurrentSession().createSQLQuery(sql);

		query.setInteger("tlid", tlid);

		query.setInteger("eid", employeeid);

		query.setInteger("pid", projectid);

		query.setString("date", date);

		query.setString("ph", prod_hours);

		int results = query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Week> getWeekList(int month, int year)
	{
		String sql = "select distinct `date` from `employees_projects` where month(`date`)= :month and year(`date`) = :year order by `date` DESC";

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		
		query.setInteger("month", month);
		
		query.setInteger("year", year);

		List<Date> week_result = query.list();
		
		System.out.println(week_result.toString());
		
		List<Week> week_list = new ArrayList<Week>();
		
		Week w;
		
		for(int i = 0; i<week_result.size(); i++)
		{
			int week = week_result.size() - i;
			
			w = new Week();
			
			w.setWeekString("Week " + week);
			
			w.setDate(week_result.get(i).toLocalDate());
			
			week_list.add(w);
		}

		return week_list;
	}

	public List<Employee> getTls()
	{
		String sql = "select id, fname from employees where role_id = 2";

		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Object[]> res = query.list();
		List<Employee> tls = new ArrayList<Employee>();
		
		Employee employee;
		
		// iterate through Object[] and create Employee List
		
		for(Object[] r: res)
		{
			employee = new Employee();
			employee.setId((Integer) r[0]);
			employee.setUname((String) r[1]);
			
			tls.add(employee);
		}
		return tls;
	}
}
