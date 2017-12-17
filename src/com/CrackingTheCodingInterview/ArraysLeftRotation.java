package com.CrackingTheCodingInterview;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLeftRotation {
	private void leftShift(int[] array, int leftShifts) {
		leftShifts = leftShifts % array.length;
		int newArray[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int newPosition = i - leftShifts;
			if (newPosition < 0) {
				newPosition += array.length;
			}
			newArray[newPosition] = array[i];
		}
		// expected printed solution contains no commas
		String solution = Arrays.toString(newArray).replace(",", "");
		System.out.println(solution.substring(1, solution.length() - 1));

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		ArraysLeftRotation s = new ArraysLeftRotation();
		s.leftShift(a, k);
	}
}
