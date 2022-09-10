package com.code.main.sorting;

public class SortingBasedProblem {

	public static int countAndMerge(int[] input, int low, int mid, int high) {

		int n1 = (mid - low + 1);
		int n2 = (high - mid);

		int[] left = new int[n1];
		int[] right = new int[n2];

		for (int index = 0; index < n1; index++)
			left[index] = input[index + low];

		for (int index = 0; index < n2; index++)
			right[index] = input[mid + 1 + index];

		int res = 0;
		int i = 0;
		int j = 0;
		int k = low;

		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				input[k++] = left[i++];
			} else {
				input[k++] = right[j++];
				res = res + (n1 - i);
			}
		}
		while (i < n1) {
			input[k++] = left[i++];
		}
		while (j < n2) {
			input[k++] = right[j++];
		}
		return res;
	}

	public static int inversionCount(int[] input, int left, int right) {

		int res = 0;
		if (left < right) {

			int mid = left + (right - left) / 2;
			res += inversionCount(input, left, mid);
			res += inversionCount(input, mid + 1, right);
			res += countAndMerge(input, left, mid, right);
		}
		return res;
	}

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
		Integer[] input = { 40, 30, 20, 10 };
		int result = inversion.apply(input);
		System.out.println(result);

		int[] numbers = { 40, 30, 20, 10 };
		result = inversionCount(numbers, result, result);
		System.out.println(result);
	}
}
