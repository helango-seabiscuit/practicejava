package com.hemalatha.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumAreaRectangle {



	public static void main(String[] args) {
		MinimumAreaRectangle areaRectangle = new MinimumAreaRectangle();
		System.out.println(areaRectangle.minAreaRect(new int[][]{ {1,1},{1,3},{3,1},{3,3},{2,2}}));//4
		System.out.println(areaRectangle.minAreaRect(new int[][]{ {1,1},{1,3},{3,1},{3,3},{4,1},{4,3}}));//2
	}

	public int minAreaRect(int[][] points) {
		Set<Points> pts = new HashSet<>();

		for(int[] p:points){
			pts.add(new Points(p[0],p[1]));
		}

		int min = Integer.MAX_VALUE;
		for(int i=0;i<points.length;i++){
			for(int j=i+1;j<points.length;j++){
				if(points[i][0] !=points[j][0] && points[i][1]!=points[j][1]){
					if(pts.contains(new Points(points[i][0],points[j][1] )) &&
							pts.contains(new Points(points[j][0],points[i][1] ))){
						min = Math.min(min,Math.abs(points[i][0]-points[j][0])*Math.abs(points[j][1]-points[i][1]));
					}
				}
			}
		}

		return min >=Integer.MAX_VALUE? 0:min;
	}
}


class Points {
	int x;
	int y;

	public Points(int x,int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return this.x+this.y;
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj){
			return true;
		}

		if(!(obj instanceof Points)){
			return false;
		}

		Points t = (Points) obj;

		return this.x == t.x && this.y == t.y;
	}
}