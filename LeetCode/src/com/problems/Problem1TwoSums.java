package com.problems;

import java.util.Arrays;

public class Problem1TwoSums {

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target=9;
		int[] value = new int[2];
		for(int i=0;i<nums.length;i++) {
			int num1=nums[i];
			for(int j=0;j<nums.length;j++) {
				if(j!=i) {
					int num2=nums[j];
					if(num1+num2==target) {
						if(i>j) {
							value[0]=i;
	                        value[1]=j;
	                        break;	
						}
						else {
							value[0]=j;
	                        value[1]=i;
	                        break;
						}
						
					}
				}
			}
		}
		System.out.println(Arrays.toString(value));

	}

}
/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1].
 * 
 */
