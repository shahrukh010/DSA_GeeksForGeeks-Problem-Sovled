package com.code.main.sorting;

import java.util.Arrays;

public class Union {

	public static java.util.function.BiConsumer<Integer[], Integer[]> union = (a, b) -> {

		int[] newArray = new int[a.length + b.length];

		for (int index = 0; index < a.length; index++)
			newArray[index] = a[index];

		for (int index = 0; index < b.length; index++)
			newArray[index] = b[index];

		Arrays.sort(newArray);

		for (int index = 0; index < newArray.length; index++)
			if (index == 0 || newArray[index] != newArray[index - 1])
				System.out.print(newArray[index] + " ");
	};

	public static void main(String[] args) {

		Integer[] a = { 3, 5, 8 };
		Integer[] b = { 2, 8, 9, 10, 15 };
		union.accept(a, b);
	}
}
