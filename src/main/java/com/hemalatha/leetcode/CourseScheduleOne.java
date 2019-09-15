package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CourseScheduleOne {

	private boolean isLoop = false;

	public boolean canFinish(int numCourses, int[][] prerequisites) {
      CourseInfo [] courses = new CourseInfo[numCourses];
      for (int i=0;i<numCourses;i++){
      	courses[i] = new CourseInfo(i);
	  }

	  for(int[] edge:prerequisites){
      	courses[edge[0]].getDependencies().add(courses[edge[1]]);
	  }

		Stack<CourseInfo> res = new Stack<>();
      Set<CourseInfo> visited = new HashSet<>();
	  for(CourseInfo courseInfo: courses){
      	if(!visited.contains(courseInfo)){
      		dfs(courseInfo,visited,res);
		}
	  }


	  return isLoop ? isLoop: res.size() >0;
	}

	private void dfs(CourseInfo courseInfo, Set<CourseInfo> visited,Stack<CourseInfo> res){
		if(visited.contains(courseInfo)){
			return;
		}
		visited.add(courseInfo);
		courseInfo.setColor(CourseColor.GRAY);
		for(CourseInfo info: courseInfo.getDependencies()){
			if(info.getColor() == CourseColor.GRAY){
				this.isLoop = true;
			}
			dfs(info,visited,res);
		}
		courseInfo.setColor(CourseColor.BLACK);
		res.push(courseInfo);

	}
}


class CourseInfo{

	private  int id;
	private Set<CourseInfo> dependencies;
	private CourseColor color;

	public CourseInfo(int id) {
		this.id = id;
		this.dependencies = new HashSet<>();
		this.color = CourseColor.WHITE;
	}


	public Set<CourseInfo> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<CourseInfo> dependencies) {
		this.dependencies = dependencies;
	}

	public CourseColor getColor() {
		return color;
	}

	public void setColor(CourseColor color) {
		this.color = color;
	}
}

enum CourseColor{

	WHITE,
	GRAY,
	BLACK;
}
