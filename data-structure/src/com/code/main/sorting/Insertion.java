package com.code.main.sorting;

import java.util.Arrays;

public class Insertion {

	public void insertion(int[] input) {

		for (int index = 1; index < input.length; index++) {

			int start = index;
			int tmp = input[start];
			int j = start - 1;

			while (j > -1 && tmp < input[j]) {

				input[j + 1] = input[j];
				j--;
			}
			input[j + 1] = tmp;

		}
	}

	public static void main(String[] args) {

		Insertion insertion = new Insertion();
//		int[] input = { 20, 5, 40, 60, 10, 30 };
		int[] input = { 0, 3, 1, 5, 4, 2, 7, 6 };
		insertion.insertion(input);
		System.out.println(Arrays.toString(input));
	}
}
