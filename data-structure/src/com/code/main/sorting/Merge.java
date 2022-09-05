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

			if (a[i] < b[j]) {
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

	public static void main(String... strings) {

		Merge merge = new Merge();
		int[] a = { -2, 10, 15, 20, 25 };
		int[] b = { 0, 5, 6, 6, 15, 18 };
		merge.sortTwoArray(a, b);
	}
}
