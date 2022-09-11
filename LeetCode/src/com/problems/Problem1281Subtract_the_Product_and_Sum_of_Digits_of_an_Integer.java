package com.problems;

import java.util.ArrayList;

public class Problem1281Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
	/*
	 * Given an integer number n, return the difference between the product of its
	 * digits and the sum of its digits.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: n = 234 Output: 15 Explanation: Product of digits = 2 * 3 * 4 = 24 Sum
	 * of digits = 2 + 3 + 4 = 9 Result = 24 - 9 = 15
	 */
	public static void main(String[] args) {
		int x=234;
		String y=Integer.toString(x);
		ArrayList<Integer> inte=new ArrayList<Integer>();
		for(int i=0;i<y.length();i++) {
			String dummy=y.substring(i, i+1);
			inte.add(Integer.valueOf(dummy));	
		}
		System.out.println(inte);
		int product=1;
		int sum=0;
		for(int i=0;i<inte.size();i++) {
			product=product*inte.get(i);
			sum=sum+inte.get(i);
		}
		System.out.println(product-sum);

	}

}
