package com.code.main.sorting;

import java.util.Arrays;

public class Selection {

	// it takes o(n2)all cases
	// Good thing is it takes less memory mostly uses in EEROM or where less read
	// and write required
	public java.util.function.Consumer<Integer[]> selectionSort = (input) -> {

		for (int index = 0; index < input.length; index++) {

			int k = index;
			for (int j = index + 1; j < input.length; j++) {

				if (input[k] > input[j])
					k = j;
			}
			int tmp = input[index];
			input[index] = input[k];
			input[k] = tmp;
		}
	};

	public static void main(String[] args) {

		Selection selection = new Selection();

		Integer[] input = { 10, 5, 8, 20, 2, -1 };
		selection.selectionSort.accept(input);
		System.out.println(Arrays.toString(input));

	}

}
