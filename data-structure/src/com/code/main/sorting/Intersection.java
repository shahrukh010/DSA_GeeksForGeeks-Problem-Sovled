package com.code.main.sorting;

public class Intersection {

	public static java.util.function.BiConsumer<Integer[], Integer[]> intersection = (a, b) -> {

		for (int index = 0; index < a.length; index++) {

			if (index > 0 && a[index] == a[index - 1])
				continue;

			for (int j = 0; j < b.length; j++) {

				if (a[index] == b[j]) {
					System.out.print(b[j]+" ");
					break;
				}
			}
		}
	};

	public static void main(String... strings) {

		Integer[] a = { 3, 5, 10, 10, 10, 15, 15, 20 };
		Integer[] b = { 5, 10, 10, 15, 30 };
		intersection.accept(a, b);

	}
}
