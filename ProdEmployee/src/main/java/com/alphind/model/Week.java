package com.alphind.model;

import java.time.LocalDate;
import java.util.List;

public class Week {
	
	private String weekString;
	
	private LocalDate date;
	
	private List<Projects> prolist;
	
	private int proSize;
	
	public int getProSize() {
		return proSize;
	}

	public void setProSize(int proSize) {
		this.proSize = proSize;
	}

	private List<Employee> tl_list;

	public String getWeekString() {
		return weekString;
	}

	public void setWeekString(String weekString) {
		this.weekString = weekString;
	}

	public List<Projects> getProlist() {
		return prolist;
	}

	public void setProlist(List<Projects> prolist) {
		this.prolist = prolist;
		this.proSize = prolist.size();

	}

	public List<Employee> getTl_list() {
		return tl_list;
	}

	public void setTl_list(List<Employee> tl_list) {
		this.tl_list = tl_list;

		
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
