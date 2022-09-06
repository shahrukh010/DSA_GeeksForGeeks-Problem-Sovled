package com.code.main.sorting;

import java.util.Arrays;

public class Merge {

	public void sortTwoArray(int[] a, int[] b) {

		int i = 0;
		int j = 0;
		int n = a.length - 1;
		int m = b.length - 1;
		int k = 0;
		int[] merge = new int[a.length + b.length];

		while (i <= n && j <= m) {

			// <=because of stability
			if (a[i] <= b[j]) {
				merge[k++] = a[i++];
			} else
				merge[k++] = b[j++];
		}

		for (; i <= n; i++)
			merge[k++] = a[i];

		for (; j <= m; j++)
			merge[k++] = b[j];

		System.out.println(Arrays.toString(merge));
	}

	public void merge(int[] input, int low, int mid, int high) {

		int i = low;
		int j = mid + 1;

		int[] merge = new int[input.length];
		int k = low;

		while (i <= mid && j <= high) {

			if (input[i] < input[j])
				merge[k++] = input[i++];
			else
				merge[k++] = input[j++];
		}

		for (; i <= mid; i++)
			merge[k++] = input[i];

		for (; j <= high; j++)
			merge[k++] = input[j];

		for (int index = low; index <= high; index++)
			input[index] = merge[index];

	}

	public void mergeSort(int[] input, int low, int high) {

		if (low < high) {

			int mid = (low + (high - low) / 2);
			mergeSort(input, low, mid);
			mergeSort(input, mid + 1, high);
			merge(input, low, mid, high);
		}
	}

	public static void main(String... strings) {

		Merge merge = new Merge();
		int[] a = { -2, 10, 15, 20, 25 };
		int[] b = { 0, 5, 6, 6, 15, 18 };
//		merge.sortTwoArray(a, b);

		int[] input = { 0, 10, 15, 20, 40, 1, 8, 11, 55, 7,-1,0,1,7,8,40,55 };
		int mid = ((0 + input.length - 1) / 2);
//		merge.merge(input, 0, mid, input.length - 1);

		merge.mergeSort(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));

	}
}
