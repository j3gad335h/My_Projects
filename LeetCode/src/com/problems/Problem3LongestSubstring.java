package com.problems;

import java.util.ArrayList;

public class Problem3LongestSubstring {

	public static void main(String[] args) {
		String s = "abcabcbbd";
		String str = "";
		str = str + s.charAt(0);
		ArrayList<Character> cr = new ArrayList<Character>();
		ArrayList<String> sr = new ArrayList<String>();
		cr.add(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			try {
				if (s.charAt(i - 1) != s.charAt(i) && !cr.contains(s.charAt(i))) {
					str = str + s.charAt(i);
					cr.add(s.charAt(i));
				} else {
					sr.add(str);
					str = "" + s.charAt(i);
					cr.clear();
					cr.add(s.charAt(i));
				}
			System.out.println(sr);
			} catch (Exception e) {

			}
		}
		System.out.println(sr);
		
	}
}
/*
 * Given a string s, find the length of the longest substring without repeating
 * characters. Example 1: Input: s = "abcabcbb" Output: 3 Explanation: The
 * answer is "abc", with the length of 3.
 * 
 * Example 2: Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with
 * the length of 1.
 * 
 */
