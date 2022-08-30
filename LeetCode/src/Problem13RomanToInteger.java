import java.util.ArrayList;
import java.util.Arrays;

public class Problem13RomanToInteger {
	
	public static int value(char x) {
		if(x=='I') {
			return 1;}
		else if (x=='V') {
			return 5;
		}
		else if (x=='X') {
			return 10;
		}
		else if (x=='L') {
			return 50;
		}
		else if (x=='C') {
			return 100;
		}
		else if (x=='D') {
			return 500;
		}
		else if (x=='M') {
			return 1000;
		}
		else
			return 0;
		
	}

	public static void main(String[] args) {

		String s = "III";
		int num=0;
		for(int i=0;i<s.length();i++) {
			int num1=value(s.charAt(i));
			if(i+1<s.length()) {
				int num2=value(s.charAt(i+1));
				if(num2>num1) {
					num=num-num1; 	
				}
				else  {
					num=num+num1; 	
				}	
			}
			else {
				num=num+num1;
			}
		}
		System.out.println("\n"+num);
	}
}
/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 * 
 * Symbol Value 
 * I 1 
 * V 5 
 * X 10 
 * L 50 
 * C 100 
 * D 500 
 * M 1000
 * 
 * For example, 2 is written as II in Roman numeral, just two ones added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * 
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There
 * are six instances where subtraction is used:
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
 * and M (1000) to make 400 and 900. Given a roman numeral, convert it to an
 * integer.
 */
