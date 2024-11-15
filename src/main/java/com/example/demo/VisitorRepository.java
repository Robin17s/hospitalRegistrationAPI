package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
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
