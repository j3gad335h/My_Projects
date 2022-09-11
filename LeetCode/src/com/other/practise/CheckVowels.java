package com.other.practise;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckVowels {

	public static void main(String[] args) {
		String s="Welcome";
		ArrayList<Character> v=new ArrayList<Character>(Arrays.asList('a','e','i','o','u'));
		System.out.println(v);
		int count=0;
		for(int i=0;i<s.length();i++) {
			if(v.contains(s.charAt(i))) {
				count++;
			}
		}
		System.out.println("Number of Vowels: "+count);

	}

}
