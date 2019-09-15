package com.hemalatha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmployeeSubordinates {

	public static void main(String[] args) {
		EmployeeSubordinates subordinates = new EmployeeSubordinates();
		Employee e1 = new Employee(1,5);
		Employee e2 = new Employee(2,3);
		Employee e3 = new Employee(3,3);
		e1.subordinates.add(2);
		e1.subordinates.add(3);
		System.out.println(subordinates.getImportance(Arrays.asList(e1,e2,e3),1));
	}


	public int getImportance(List<Employee> employees, int id) {
		Map<Integer,Employee> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		Employee start = null;
		for(Employee e:employees){
			map.put(e.id,e);
			if(id==e.id){
				start = e;
			}
		}

		int res = dfs(start,map,visited);

		return res;
	}

	public int dfs(Employee e,Map<Integer,Employee> map,Set<Integer> visited){
		if(visited.contains(e.id)){
			return 0;
		}
		visited.add(e.id);
		int res =0;
		for (Integer i:e.subordinates){
			res += dfs(map.get(i),map,visited);
		}
		return res +e.importance;
	}
}

class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;

	public Employee(int id, int importance) {
		this.id = id;
		this.importance = importance;
		this.subordinates = new ArrayList<>();
	}
};
