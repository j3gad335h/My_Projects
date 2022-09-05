package com.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Problem1491AverageSalary {

	public static void main(String[] args) {
		int[] salary = { 48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000, 33000,
				28000, 4000, 54000, 67000, 6000, 1000, 11000 };

		ArrayList<Integer> salaryArray = new ArrayList<>();
		for (int i = 0; i < salary.length; i++) {
			salaryArray.add(salary[i]);
		}
		System.out.println(salaryArray);
		Collections.sort(salaryArray);
		System.out.println(salaryArray);
		double sum = 0;
		double count = 0;
		for (int j = 1; j < salaryArray.size() - 1; j++) {
			sum = sum + salaryArray.get(j);
			count++;
		}
		System.out.println(sum);
		System.out.println(count);
		double average = (sum / count);
		System.out.println(average);

	}

}
