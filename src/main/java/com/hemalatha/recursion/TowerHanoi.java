package com.hemalatha.recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerHanoi {

	public static void main(String[] args) {
		System.out.println(towerOfHanoi(2,0,2,1));
		System.out.println(towerOfHanoi(3,0,2,1));
	}

	public static List<Move>  towerOfHanoi(int n, int src, int des, int aux){
		if(n<=0){
			return new ArrayList<Move>();
		}

		List<Move> res = new ArrayList<>();
		res.addAll(towerOfHanoi(n-1,src,aux,des));
		res.add(new Move(n,src,des));
		res.addAll(towerOfHanoi(n-1,aux,des,src));
		return res;
	}

}


class Move{

	private int diskNumber;
	private int src;
	private int dest;

	public Move(int diskNumber, int src, int dest) {
		this.diskNumber = diskNumber;
		this.src = src;
		this.dest = dest;
	}

	public int getDiskNumber() {
		return diskNumber;
	}

	public int getSrc() {
		return src;
	}

	public int getDest() {
		return dest;
	}

	@Override
	public String toString() {
		return "Move{" +
				"diskNumber=" + diskNumber +
				", src=" + src +
				", dest=" + dest +
				'}';
	}
}
