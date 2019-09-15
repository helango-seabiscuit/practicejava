package com.hemalatha.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {


	public static void main(String[] args) {
		WallsAndGates wallsAndGates = new WallsAndGates();
		//System.out.println(Integer.MAX_VALUE);
		int [][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
		wallsAndGates.wallsAndGates(rooms);
		System.out.println(rooms);
	}

	public void wallsAndGates(int[][] rooms) {

		Queue<int[]> queue = new LinkedList<>();
		if (rooms == null || rooms.length==0) {
			return;
		}
		int row = rooms.length;
		int col = rooms[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (rooms[i][j] == 0) {
					queue.add(new int[]{i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] r = queue.poll();
			if (r[0] + 1 < row && rooms[r[0] + 1][r[1]] ==Integer.MAX_VALUE) {
					rooms[r[0] + 1][r[1]] = rooms[r[0]][r[1]]+1;
					queue.add(new int[]{r[0] + 1, r[1]});

			}

			if (r[0] - 1 >= 0 && rooms[r[0] - 1][r[1]] ==Integer.MAX_VALUE) {
					rooms[r[0] - 1][r[1]] = rooms[r[0]][r[1]]+1;
					queue.add(new int[]{r[0] - 1, r[1]});
			}

			if (r[1] + 1 < col && rooms[r[0]][r[1] + 1] ==Integer.MAX_VALUE) {
					rooms[r[0]][r[1] + 1] = rooms[r[0]][r[1]]+1;
					queue.add(new int[]{r[0], r[1] + 1});
			}
			if (r[1] - 1 >= 0 && rooms[r[0]][r[1] - 1] ==Integer.MAX_VALUE) {

					rooms[r[0]][r[1] - 1] = rooms[r[0]][r[1]]+1;
					queue.add(new int[]{r[0], r[1] - 1});
			}
		}
	}
}
