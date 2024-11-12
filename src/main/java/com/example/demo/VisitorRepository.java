package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class VisitorRepository {

	List<Visitor> list;
	
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
