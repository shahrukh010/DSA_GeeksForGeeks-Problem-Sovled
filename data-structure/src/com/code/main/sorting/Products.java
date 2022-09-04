package com.code.main.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Products implements Comparable<Products> {

	private String name;
	private int price;

	public Products() {
	}

	public Products(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public int compareTo(Products p1) {

		return this.price - p1.price;
	}

	@Override
	public String toString() {

		return this.name + " " + this.price;

	}

	public static void main(String... strings) {

		ArrayList<Products> products = new ArrayList<Products>();
		products.add(new Products("Laptop", 45000));
		products.add(new Products("SDD", 9000));
		products.add(new Products("HDD", 6000));
		products.add(new Products("RAM", 7500));
		System.out.println(products);
		Collections.sort(products);
		System.out.println(products);
	}
}
