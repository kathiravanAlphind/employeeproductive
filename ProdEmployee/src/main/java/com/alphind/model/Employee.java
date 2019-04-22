package com.alphind.model;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3465813074586302847L;	
	
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "employees_projects", 
        joinColumns = { @JoinColumn(name = "employee_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "project_id") }
    )
    List<Projects> projects = new ArrayList<Projects>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int id;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private int role_id;
	
	private float prod_hours;
	
	private String idString;
	
	private String htmlname;

	public String getHtmlname() {
		return htmlname;
	}
	public void setHtmlname(String htmlname) {
		this.htmlname = htmlname;
	}
	
	public float getProd_hours() {
		return prod_hours;
	}
	public void setProd_hours(float prod_hours) {
		this.prod_hours = prod_hours;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
		this.idString = Integer.toString(id);
	}
	
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getFname()
	{
		return fname;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}
	public void setUname(String fname)
	{
		this.fname = fname;
	}
	
	public String getLname()
	{
		return lname;
	}
	
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	
	
	public int getrole_id() {
		return role_id;
	}
	
	public void setrole_id(int role_id)
	{
		this.role_id = role_id;
	}

	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	
}