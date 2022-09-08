package com.code.main.sorting;

public class SortingBasedProblem {

	public static java.util.function.Function<Integer[], Integer> inversion = (input) -> {

		int res = 0;
		for (int index = 0; index < input.length; index++) {

			for (int j = index + 1; j < input.length; j++) {

				if (input[index] > input[j])
					res++;

			}
		}
		return res;
	};

	public static void main(String... strings) {

//		Integer[] input = { 2, 4, 1, 3, 5 };
//		Integer[] input = { 10, 20, 30, 40, 50 };
		Integer[] input = { 40, 30, 20, 10};
		int result = inversion.apply(input);
		System.out.println(result);
	}
}
