package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

public class CourseSchedule {

	private  boolean isLoop = false;
	public static void main(String[] args) {
		CourseSchedule schedule = new CourseSchedule();
		System.out.println(Arrays.toString(schedule.findOrder(3,new int[][]{{1, 0}})));//0,1
		System.out.println(Arrays.toString(schedule.findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}})));//0,1,2,3 or 0,2,1,3
		System.out.println(Arrays.toString(schedule.findOrder(2,new int[][]{{0,1},{1,0}})));//[]
		System.out.println(Arrays.toString(schedule.findOrder(3,new int[][]{{1,0},{0,2},{2,1}})));//[]
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Course [] coursesPresent = new Course[numCourses];
		Stream.iterate(0,i-> i+1).limit(numCourses).forEach(
				i-> {
					coursesPresent[i]= new Course(i);
				});
         for(int [] edge: prerequisites){
         	Set<Course> dependencies = coursesPresent[edge[0]].getCourseDependency();
			dependencies.add(coursesPresent[edge[1]]);
		 }

		Stack<Course> stack = new Stack<>();
         Set<Course> visited = new HashSet<>();
         for(int i=0;i<numCourses;i++){
         	if(!visited.contains(coursesPresent[i])){
         		traverseCourseDependencies(coursesPresent[i],stack,visited);
			}
		 }

		 if(isLoop){
         	return new int[]{};
		 }
		 int [] res = new int[stack.size()];
         int i=stack.size()-1;
         while (!stack.isEmpty()){
         	res[i--]= stack.pop().getId();
		 }
		 return res;
	}

	public void traverseCourseDependencies(Course course, Stack<Course> stack, Set<Course> visited){
		if(visited.contains(course)){
			return;
		}
		visited.add(course);
		course.setCurrColor(Color.GRAY);
		for(Course c: course.getCourseDependency()){
			if(c.getCurrColor() == Color.GRAY){
				isLoop = true;
			}
			traverseCourseDependencies(c,stack,visited);
		}
		course.setCurrColor(Color.BLACK);
		stack.push(course);
	}
}

class Course {
	private int id;
	private Set<Course> courseDependency;
	private Color currColor;

	public Course(int id) {
		this.id = id;
		this.courseDependency = new HashSet<>();
		this.currColor = Color.WHITE;
	}

	public int getId() {
		return id;
	}

	public Set<Course> getCourseDependency() {
		return courseDependency;
	}

	public void setCourseDependency(Set<Course> courseDependency) {
		this.courseDependency = courseDependency;
	}

	public Color getCurrColor() {
		return currColor;
	}

	public void setCurrColor(Color currColor) {
		this.currColor = currColor;
	}
}

enum  Color {
	WHITE,
	GRAY,
	BLACK;
}
