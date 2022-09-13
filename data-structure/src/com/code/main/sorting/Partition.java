package com.code.main.sorting;

import java.util.Arrays;

public class Partition {

	public static void partitionOFArray(int[] input, int low, int high) {

		int[] tmp = new int[(high - low + 1)];
		int p = input.length - 1;
		int index = 0;

		for (int i = low; i < high; i++) {

			if (input[i] <= input[p])
				tmp[index++] = input[i];
		}

		for (int i = low; i < high; i++) {

			if (input[i] >= input[p])
				tmp[index++] = input[i];
		}

		System.out.println(Arrays.toString(tmp));
	}

	public static void main(String... strings) {

		int[] numbers = { 5, 13, 6, 9, 12, 11, 8 };

		partitionOFArray(numbers, 0, numbers.length );

	}
}
