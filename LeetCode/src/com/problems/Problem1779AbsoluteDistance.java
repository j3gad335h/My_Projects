package com.problems;

import java.util.Arrays;

public class Problem1779AbsoluteDistance {

	public static void main(String[] args) {
		int x1 = 3;
		int y1 = 4;
		int[][] co = new int[][] { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } };

		/*
		 * The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 -
		 * x2) + abs(y1 - y2). A point is valid if it shares the same x-coordinate or
		 * the same y-coordinate as your location.
		 */
		int x3 = co[0][0];
		int y3 = co[0][1];
		int distance1 = Math.abs(x1 - x3) + Math.abs(y1 - y3);
		for (int i = 1; i <co.length; i++) {
			int x2 = co[i][0];
			int y2 = co[i][1];
			int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
			if (distance < distance1 && (x2==x1 || y2==y1)) {
				System.out.println("X2 x1 "+ x2+" "+ x1);
				System.out.println(i);
			}
		}

	}

}
