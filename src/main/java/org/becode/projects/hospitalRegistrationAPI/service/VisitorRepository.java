package org.becode.projects.hospitalRegistrationAPI.service;

import java.util.ArrayList;
import java.util.List;

import model.Visitor;

public class VisitorRepository {

	private List<Visitor> list;
	
	public VisitorRepository() {
		this.list = new ArrayList<>();
	}
	
	public void add(Visitor visitor) {
		list.add(visitor);
	}

	public List<Visitor> getList() {
		return list;
	}
	
	
}
