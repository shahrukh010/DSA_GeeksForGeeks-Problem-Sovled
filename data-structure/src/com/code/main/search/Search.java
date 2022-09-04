package com.code.main.search;

import java.util.Arrays;

public class Search {

	public java.util.function.BiPredicate<Integer[], Integer> binarySearch = (input, target) -> {

		int left = 0;
		int right = input.length - 1;

		while (left <= right) {

			int mid = ((left + right) / 2);

			if (input[mid] == target)
				return true;

			if (input[mid] < target) {

				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}
		return false;
	};

	public int binarySearch(int[] input, int left, int right, int target) {

		if (left <= right) {

			int mid = ((left + right) / 2);

			if (input[mid] == target)
				return mid;
			if (input[mid] < target) {

				return binarySearch(input, mid + 1, right, target);
			} else
				return binarySearch(input, left, mid - 1, target);
		}
		return -1;
	}

	// O(N)
	public java.util.function.BiFunction<Integer[], Integer, Integer> firstOccurence = (input, target) -> {

		for (int index = 0; index < input.length; index++) {

			if (input[index] == target)
				return index;
		}
		return -1;
	};

	// optimize (logn) using binary search because array given is sorted

	public int firstOccurence(int[] input, int target) {

		int left = 0;
		int right = input.length - 1;

		while (left <= right) {

			int mid = ((left + right) / 2);

			if (input[mid] == target) {

				if (mid == 0 || input[mid - 1] != target)
					return mid;
				right = mid - 1;
			} else if (input[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;

		}
		return -1;
	}

	public java.util.function.BiFunction<Integer[], Integer, Integer> lastOccurence = (input, target) -> {

		int left = 0;
		int right = input.length - 1;

		while (left <= right) {

			int mid = ((left + right) / 2);

			if (input[mid] == target) {

				if (mid == input.length - 1 || input[mid + 1] != target)
					return mid;
				left = mid + 1;
			}

			else if (input[mid] < target)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return -1;

	};

	public java.util.function.BiFunction<Integer[], Integer, Integer> countOccurence = (input, target) -> {

		int[] numbers = Arrays.stream(input).mapToInt(Integer::intValue).toArray();

		int firstOccr = firstOccurence(numbers, target);
		int lastOccr = lastOccurence.apply(input, target);

		if (firstOccr != -1 && lastOccr != -1)
			return lastOccr - firstOccr + 1;

		return 0;
	};

	public java.util.function.Function<Integer[], Integer> count1s = (input) -> {

		int[] numbers = Arrays.stream(input).mapToInt(Integer::intValue).toArray();

		int firstOccrence = firstOccurence(numbers, 1);

		if (firstOccrence != -1)
			return input.length - firstOccrence;
		return 0;
	};

	public java.util.function.Function<Integer, Integer> sqrt = (x) -> {

		int index = 1;
		while (index * index <= x) {

			index++;
		}
		return index - 1;
	};

	public java.util.function.Function<Integer, Integer> squareRoot = (input) -> {

		int left = 1;
		int right = input;
		int result = 0;

		while (left <= right) {

			int mid = ((left + right) / 2);
			int msq = mid * mid;

			if (msq == input)// for perfect square
				return mid;

			if (msq > input)
				right = mid - 1;
			else {
				left = mid + 1;
				result = mid;
			}
		}
		return result;
	};

	public java.util.function.BiFunction<int[], Integer, Integer> infinteSearch = (input, target) -> {

		if (input[0] == target)
			return 0;
		int index = 1;
		while (index < input.length && input[index] < target) {

			index = index * 2;
		}
		if (input[index] == target)
			return index;

		return binarySearch(input, index / 2 + 1, index, target);

	};

	public int searchInSortedRotatedArray(int[] input, int target) {

		int left = 0;
		int right = input.length - 1;

		while (left <= right) {

			int mid = ((left + right) / 2);

			if (input[mid] == target)
				return mid;

			if (input[left] < input[mid]) {

				if (target >= input[left] && target < input[right]) {

					right = mid - 1;
				} else
					left = mid + 1;
			} else {

				if (target > input[mid] && target <= input[input.length - 1]) {

					left = mid + 1;
				} else
					right = mid - 1;
			}
		}
		return -1;

	};

	public java.util.function.Function<Integer[], Integer> peakElement = (input) -> {

		int n = input.length;
		if (n == 1)
			return input[0];

		int left = 0;
		int right = n - 1;

		while (left <= right) {

			int mid = ((left + right) / 2);

			if ((mid == 0 || input[mid - 1] <= input[mid]) && (mid == n - 1 || input[mid + 1] <= input[mid]))
				return mid;

			if (mid == 0 || input[mid - 1] > input[mid])
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	};

	public java.util.function.BiPredicate<Integer[], Integer> pairSum = (input, target) -> {

		for (int index = 0; index < input.length; index++) {

			for (int sIndex = index + 1; sIndex < input.length; sIndex++) {

				// not required to occupied memory for checking condition

//				int pairSum = input[index] + input[sIndex];
//
//				if (pairSum == target)
//					return true;

				if (input[index] + input[sIndex] == target)
					return true;

			}
		}
		return false;
	};

	public java.util.function.BiPredicate<Integer[], Integer> pairSumExists = (input, target) -> {

		int start = 0;
		int end = input.length - 1;

		while (start <= end) {
			if (input[start] + input[end] == target)
				return true;

			if (input[start] + input[end] > target)
				end--;
			else
				start++;
		}
		return false;
	};

	public java.util.function.BiPredicate<Integer[], Integer> tripletSortedArray = (input, target) -> {

		for (int index = 0; index < input.length - 2; index++) {

			for (int j = index + 1; j < input.length - 1; j++) {

				for (int k = j + 1; k < input.length; k++) {

					int sum = input[index] + input[j] + input[k];

					if (sum == target)
						return true;
				}
			}
		}
		return false;
	};

	public double findMedianOfTwoSortedArray(int[] a, int[] b) {

		int[] median = new int[a.length + b.length];
		int n = median.length;

		int k = 0;
		for (int index = 0; index < a.length; index++)
			median[k++] = a[index];
		for (int index = 0; index < b.length; index++)
			median[k++] = b[index];
		Arrays.sort(median);
		System.out.println(Arrays.toString(median));

		if (n % 2 != 0)
			return median[(median.length - 1) / 2];

		else
			return (median[(n / 2) - 1] + median[((n / 2) - 1) + 1]) / 2;
	};

	// optimize solution O(N)2
	public java.util.function.BiPredicate<Integer[], Integer> tripletEqaulToTarget = (input, target) -> {

		for (int index = 0; index < input.length; index++) {

			int start = index + 1;
			int end = input.length - 1;
			int numberToFind = target - input[index];
			while (start <= end) {

				int sum = input[start] + input[end];

				if (numberToFind == sum)
					return true;
				if (sum > target)
					end--;
				else
					start++;
			}
		}
		return false;
	};

	// Repeating element witout modifying array O(N)t/s

	public java.util.function.Function<Integer[], Integer> repeatEl = (input) -> {

		int slow = input[0];
		int fast = input[0];
		do {
			slow = input[slow];
			fast = input[input[fast]];

		} while (slow != fast);

		slow = input[0];
		while (slow != fast) {
			slow = input[slow];
			fast = input[fast];
		}
		return slow;

	};

	public static void main(String... strings) {

		Search search = new Search();
////		Integer[] input = { 0, 10, 20, 30, 40, 50, 60, 70, 90 };
//		boolean result = search.binarySearch.test(input, 0);
//		System.out.println(result);
//		int[] input = { 0, 10, 20, 30, 40, 50, 60, 70, 90 };
//		int res = search.binarySearch(input, 0, input.length - 1, 90);
//		System.out.println(res);

//		Integer[] input = { 1, 10, 10, 10, 20, 20, 40 };
//		int result = search.firstOccurence.apply(input, 10);
//		System.out.println(result);
//		int[] number = { 1, 10, 10, 10, 20, 20, 40 };
//		int[] number = { 5, 5, 5 }
//		result = search.firstOccurence(number, 5);
//		System.out.println(result);
//		Integer[] numbers = { 5, 5, 5, 5 };
//		result = search.lastOccurence.apply(numbers, 5);
//		System.out.println(result);
//		Integer[] nums = { 5, 8, 10 };
//		int occurence = search.countOccurence.apply(nums, 7);
//		System.out.println(occurence);

//		Integer[] count1s = { 0, 0, 0, 0, 1, 1, 1, 1 };
//		Integer[] count1s = { 0, 0, 0, 0, 0, 0, 0 };
//		Integer[] count1s = { 1, 1, 1, 1, 1, 1, 1 };
//		result = search.count1s.apply(count1s);
//		System.out.println(result);

//		int sqrt = 4;
//		System.out.println(search.sqrt.apply(sqrt));
//		System.out.println(search.sqrt.apply(14));
//		System.out.println(search.sqrt.apply(25));
//		System.out.println(search.squareRoot.apply(25));

//		int[] number = { 1, 10, 15, 20, 40, 80, 90, 100, 120, 500, 1000 };
//
//		int result = search.infinteSearch.apply(number, 120);
//		System.out.println(result);
//
//		int[] input = { 10, 20, 40, 60, 5, 8 };
//
//		result = search.searchInSortedRotatedArray(input, 5);
//		System.out.println(result);

//		Integer[] input = { 5, 20, 40, 30, 20, 50, 60 };
//		Integer[] input = { 5, 10, 20, 40, 60, 70, 80 };
//
//		int result = search.peakElement.apply(input);
//		System.out.println(result);

//		Integer[] input = { 3, 8, 13, 18 };
//		Integer[] input = { 2, 5, 8, 12, 30 };
//		Integer[] input = { 2, 4, 8, 9, 11, 12, 20, 30 };
//		boolean result = search.pairSum.test(input, -23);
//		System.out.println(result);
//		result = search.pairSumExists.test(input, -23);
//		System.out.println(result);

//		Integer[] input = { 2, 3, 4, 8, 9, 20, 40 };
//		Integer[] input = { 1, 2, 5, 6 };
//		boolean result = search.tripletSortedArray.test(input, 32);
//		boolean res = search.tripletEqaulToTarget.test(input, 32);
//		System.out.println(result);
//		System.out.println(res);

//		int[] a = { 10, 20, 30, 40, 50 };
//		int[] b = { 5, 15, 25, 35, 45 };

//		int[] a = { 1, 2, 3, 4, 5, 6 };
//		int[] b = { 10, 20, 30, 40, 50 };

//		int[] a = { 10, 20, 30, 40, 50, 60 };
//		int[] b = { 1, 2, 3, 4, 5 };
//
//		double result = search.findMedianOfTwoSortedArray(a, b);
//		System.out.println(result);

		Integer[] input = { 1, 3, 2, 4, 6, 5, 7, 3 };
		Integer result = search.repeatEl.apply(input);
		System.out.println(result);

	}
}
