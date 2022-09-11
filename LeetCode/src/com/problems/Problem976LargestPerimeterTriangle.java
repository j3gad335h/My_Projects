package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem976LargestPerimeterTriangle {
	/*
	 * Triangle has three sides a,b,c
	 * 
	 */

	public static void main(String[] args) {
		int[] nums = {3,2,3,4};
		Arrays.sort(nums);
        int n= nums.length;
        for (int i =n - 1; i > 1; --i)
            if (nums[i] < nums[i - 1] + nums[i - 2])
               System.out.println(nums[i] + nums[i - 1] + nums[i - 2]);
       
		
	}

}
