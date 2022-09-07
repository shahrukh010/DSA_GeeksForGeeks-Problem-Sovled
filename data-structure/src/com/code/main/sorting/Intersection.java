package com.code.main.sorting;

public class Intersection {

	// n*m
	public static java.util.function.BiConsumer<Integer[], Integer[]> intersection = (a, b) -> {

		for (int index = 0; index < a.length; index++) {

			if (index > 0 && a[index] == a[index - 1])
				continue;

			for (int j = 0; j < b.length; j++) {

				if (a[index] == b[j]) {
					System.out.print(b[j] + " ");
					break;
				}
			}
		}
	};

	public static java.util.function.BiConsumer<Integer[], Integer[]> intrsn = (a, b) -> {

		int j = 0;
		int index = 0;
		while (index < a.length && j < b.length) {

			if (index > 0 && a[index] == a[index - 1]) {
				index++;
				continue;
			}

			if (a[index] == b[j])
				System.out.print(a[index] + " ");

			if (a[index] < b[j])
				index++;
			else if (a[index] > b[j])
				j++;
			else {
				index++;
				j++;
			}
		}
	};

	public static void main(String... strings) {

		Integer[] a = { 3, 5, 10, 10, 10, 15, 15, 20 };
		Integer[] b = { 5, 10, 10, 15, 30 };
		Integer[] c = { 2, 20, 20, 40, 60 };
		Integer[] d = { 10, 20, 20, 20 };
		intersection.accept(a, b);
		intrsn.accept(a, b);
		intrsn.accept(c, d);
	}
}
