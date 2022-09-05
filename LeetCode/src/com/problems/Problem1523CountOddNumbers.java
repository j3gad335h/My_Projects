package com.problems;

import java.util.ArrayList;

public class Problem1523CountOddNumbers {
	public int countOdds(int low, int high) {
		int count=0;
		if(!(low%2==0 && high%2==0)) {
			count=((high-low)/2)+1;
			return count;
					
		}
		else if(!(low%2==0 || high%2==0)) {
			count=((high-low)/2)+1;
			return count;
		}
		else if(low%2==0 && high%2==0) {
			count=((high-low)/2);
			return count;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
