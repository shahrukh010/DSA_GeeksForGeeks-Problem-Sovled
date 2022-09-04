package com.code.main.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Product implements Comparator<Product> {

	protected int id;
	protected int price;

	public Product() {
	}

	public Product(int id, int price) {
		this.id = id;
		this.price = price;
	}

	@Override
	public int compare(Product p1, Product p2) {

		return p1.id - p2.price;
	}

	public String toString() {

		return this.id + " " + this.price;
	}
}

public class Points implements Comparable<Points> {

	private int id;
	private int serialNumber;

	public Points(int id, int serialNumber) {
		this.id = id;
		this.serialNumber = serialNumber;
	}

	public String toString() {
		return this.id + "," + this.serialNumber;
	}

	@Override
	public int compareTo(Points arg0) {

		return this.id - arg0.serialNumber;
	}

	public static void main(String[] args) {

		Points[] arr = { new Points(2, 2), new Points(1, 1) };
		Arrays.sort(arr);

		System.out.println(Arrays.toString(arr));

		Product[] product = { new Product(2, 200), new Product(1, 400) };
		System.out.println(product[0].id);
		Arrays.sort(product, new Product());
		System.out.println(product[0].id);
//		System.out.println(Arrays.toString(product));

		Integer[] input = { 5, 3, 1, 2, 0 };
		Arrays.sort(input, Collections.reverseOrder());
		System.out.println(Arrays.toString(input));
	}
}
