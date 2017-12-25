package com.CrackingTheCodingInterview;

import java.util.ArrayList;
import java.util.Scanner;

public class RunningMedian {

	private double printMedian(ArrayList<Integer> b) {
		if (b.size() % 2 == 0) {
			int first = (b.size() / 2) - 1;
			int second = first + 1;
			return (double) (b.get(first) + b.get(second)) / 2;

		}
		return b.get(b.size() / 2);

	}

	private int getIndexToInsert(ArrayList arr, int l, int r, int numberToFind) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if ((int) arr.get(mid) == numberToFind) {
				return mid;
			}
			if ((int) arr.get(mid) > numberToFind) {
				if (mid == 0) {
					return 0;
				}
				return getIndexToInsert(arr, 0, mid - 1, numberToFind);
			} else {

				return getIndexToInsert(arr, mid + 1, r, numberToFind);
			}
		}
		if (numberToFind < (int) arr.get(r)) {
			return r;
		} else {
			return r + 1;
		}

	}

	private void findMedian(int input[]) {
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(input[0]);
		System.out.println((double) b.get(0));
		for (int i = 1; i < input.length; i++) {
			b.add(getIndexToInsert(b, 0, b.size() - 1, input[i]), input[i]);
			System.out.println(printMedian(b));
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] a = new int[n];

		for (int a_i = 0; a_i < n; a_i++) {

			a[a_i] = in.nextInt();

		}

		RunningMedian rm = new RunningMedian();
		rm.findMedian(new int[] { 12, 4, 5, 3, 8, 7 });
	}
}
