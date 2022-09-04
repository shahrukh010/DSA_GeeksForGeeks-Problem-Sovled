package com.code.main.sorting;

import java.util.Arrays;

public class Bubble {

	// this solution always take o(N2) time whether element are sorted or not.
	public void bubbleSort(int[] input) {

		for (int index = 0; index < input.length; index++) {

			for (int j = 0; j < input.length - index - 1; j++) {

				if (input[j] > input[j + 1]) {

					int tmp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = tmp;
				}
			}
		}
	}

	// optimze if in case element are sorted
	public java.util.function.Consumer<Integer[]> bubbleAlgo = (input) -> {

		boolean flag = true;
		for (int index = 0; index < input.length; index++) {

			for (int j = 0; j < input.length - index - 1; j++) {

				if (input[j] > input[j + 1]) {
					int tmp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = tmp;
					flag = false;
				}

			}
			if (flag)
				break;
		}
	};

	public static void main(String... strings) {

		Bubble bubble = new Bubble();
		int[] input = { 2, 10, 8, 7, 0 };
//		int[] input = { 5, 3, 1, 0, -1, 2, 5, 4, 4 };
		// bubble.bubbleSort(input);
//		Integer[] numbers = { 5, 3, 1, 0, -1, 2, 5, 4, 4 };
		Integer[] numbers = { 1, 2, 3, 4, 5, 6 };

		bubble.bubbleAlgo.accept(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
