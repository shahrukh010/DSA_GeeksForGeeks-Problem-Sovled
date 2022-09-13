package com.code.main.sorting;

public class MergeSortBasedProblem {

	public static int merge(int[] input, int low, int mid, int high) {

		int n1 = (mid - low) + 1;
		int n2 = (high - mid);

		int left[] = new int[n1];
		int right[] = new int[n2];

		for (int index = 0; index < n1; index++) {

			left[index] = input[index + low];
		}
		for (int index = 0; index < n2; index++) {
			right[index] = input[mid + 1 + index];
		}

		int res = 0;
		int i = 0;
		int j = 0;
		int k = low;

		while (i < n1 && j < n2) {

			if (left[i] <= right[j])
				input[k++] = left[i++];
			else {
				input[k++] = right[j++];
				res = res + (n1 - i);
			}
		}
		while (i < n1)
			input[k++] = left[i++];
		while (j < n2)
			input[k++] = right[j++];

		return res;
	}

	public static int countInversion(int[] input, int low, int high) {

		int res = 0;
		if (low < high) {

			int mid = (low + (high - low) / 2);

			res += countInversion(input, low, mid);
			res += countInversion(input, mid + 1, high);
			res += merge(input, low, mid, high);
		}
		return res;
	}

	public static void main(String... strings) {

		int[] input = { 1, 20, 6, 7, 5, 8, 11, 3 };

		int result = countInversion(input, 0, input.length - 1);
		System.out.println(result);

	}
}
