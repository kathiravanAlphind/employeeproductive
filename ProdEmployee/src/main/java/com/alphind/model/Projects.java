package com.alphind.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

import java.util.*;


@Entity
@Table(name = "projects")
public class Projects implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2684197356000468736L;
	
	private String idString;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String pname;
	
	private float prod_hours;
	
	public Projects() {
		
	}
	
	public Projects(int _id, String _pname, float _prod_hours) {
		this.id = _id;
		this.pname = _pname;
		this.prod_hours = _prod_hours;
	}
	
		
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	
	private int empSize;
	
	public int getEmpSize() {
		return empSize;
	}

	public void setEmpSize(int empSize) {
		this.empSize = empSize;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		
		for(Employee e:employees)
		{
			e.setHtmlname(this.idString + "-" + e.getIdString());
		}
		this.employees = employees;
		this.empSize = employees.size();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		this.idString = Integer.toString(id);
	}
	
	public String getIdString() {
		return idString;
	}

	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getPname() {
		return pname;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}

	public float getProd_hours() {
		return prod_hours;
	}

	public void setProd_hours(float prod_hours) {
		this.prod_hours = prod_hours;
	}    
	
}
