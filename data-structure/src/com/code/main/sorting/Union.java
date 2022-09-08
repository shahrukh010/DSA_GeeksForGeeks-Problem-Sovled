package com.code.main.sorting;

import java.util.Arrays;

public class Union {

	// Naive :O(m+n) * log(m+n)
	public static java.util.function.BiConsumer<Integer[], Integer[]> union = (a, b) -> {

		int[] newArray = new int[a.length + b.length];

		int index = 0;
		for (index = 0; index < a.length; index++)
			newArray[index] = a[index];

		for (int j = 0; j < b.length; j++)
			newArray[index++] = b[j];

		Arrays.sort(newArray);

		for (int k = 0; k < newArray.length; k++)
			if (k == 0 || newArray[k] != newArray[k - 1])
				System.out.print(newArray[k] + " ");
	};

	// O(m+n)
	public static java.util.function.BiConsumer<Integer[], Integer[]> unionTwoSortedArray = (a, b) -> {

		int i = 0;
		int j = 0;
		int n = a.length - 1;
		int m = b.length - 1;

		while (i <= n && j <= m) {

			if (i > 0 && a[i] == a[i - 1])
				i++;
			if (j > 0 && b[j] == b[j - 1])
				j++;

			if (a[i] < b[j]) {
				System.out.print(a[i] + " ");
				i++;
			} else if (a[i] > b[j]) {
				System.out.print(b[j] + " ");
				j++;
			} else {
				System.out.print(a[i] + " ");
				i++;
				j++;
			}
		}

		for (; i < a.length; i++) {

			if (a[i] != a[i - 1])
				System.out.print(a[i] + " ");
		}
		for (; j < b.length; j++)
			if (b[j] != b[j - 1])
				System.out.print(b[j] + " ");
	};

	public static void main(String[] args) {

		Integer[] a = { 3, 5, 8 };
		Integer[] b = { 2, 8, 9, 10, 15 };
		union.accept(a, b);
		System.out.println();
		unionTwoSortedArray.accept(a, b);

	}
}
