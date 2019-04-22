package com.alphind.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alphind.model.Projects;


@Repository
public class ProjectsDAOImpl implements ProjectsDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Projects> listAllProjects() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Projects").list();
	}

}
