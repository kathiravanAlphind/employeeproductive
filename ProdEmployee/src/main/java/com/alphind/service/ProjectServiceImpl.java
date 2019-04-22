package com.alphind.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphind.dao.ProjectsDAO;
import com.alphind.model.Projects;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectsDAO projectdao;

	public List<Projects> listAllProjects() {
		// TODO Auto-generated method stub
		return projectdao.listAllProjects();
	}
	
	
	

}
