package com.code.main.array;

import java.util.Arrays;

public class Array {

	public java.util.function.Function<Integer[], Integer> majorityElement = (input) -> {

		int res = 0;

		for (int index = 0; index < input.length; index++) {

			for (int sIndex = index + 1; sIndex < input.length; sIndex++) {

				if (input[index] == input[sIndex]) {

					res++;
				}
				if (res > input.length / 2) {
					return index;
				}
			}
		}
		return Integer.MIN_VALUE;
	};

	// optimize solution
	private java.util.function.Function<Integer[], Integer> getCandidate = (input) -> {

		int candidate = input[0];
		int count = 1;
		for (int index = 1; index < input.length; index++) {

			if (input[index] == candidate)
				count++;
			else {

				count--;
				if (count == 0) {
					count = 1;
					candidate = input[index];
				}
			}
		}
		return candidate;
	};

	public java.util.function.Consumer<Integer[]> mjrElement = (input) -> {

		int candidate = getCandidate.apply(input);
		int count = 0;

		for (int index = 0; index < input.length; index++) {

			if (candidate == input[index])
				count++;
			if (count > input.length / 2) {
				System.out.println(index + "--->" + candidate);
				break;
			}

		}
	};

	public java.util.function.Consumer<Integer[]> miniumGroupToFlip = (input) -> {

		for (int index = 1; index < input.length; index++) {

			if (input[index] != input[index - 1]) {

				if (input[index] != input[0]) {

					System.out.print("[" + index + ",");
				} else {
					System.out.print(index - 1 + "] ");
				}
			}

		}
		if (input[input.length - 1] != input[0])
			System.out.print(input.length - 1 + "]");
	};

	public java.util.function.BiFunction<Integer[], Integer, Integer> maxSumOfKthConsecutive = (input, k) -> {

		int result = 0;

		for (int index = 0; index + k - 1 < input.length; index++) {

			int currentSum = 0;
			for (int sIndex = 0; sIndex < k; sIndex++) {

				currentSum += input[index + sIndex];
			}
			result = Math.max(result, currentSum);
		}
		return result;
	};

	// using optimize(Window technique)
	public java.util.function.BiFunction<Integer[], Integer, Integer> maxSumKthConsec = (input, k) -> {

		Integer result = 0;
		int currentSum = 0;
		for (int index = 0; index < k; index++) {

			currentSum += input[index];
		}

		result = currentSum;

		for (int index = k; index < input.length; index++) {

			currentSum += input[index] - input[index - k];
			result = Math.max(currentSum, result);
		}
		return result;
	};

	public java.util.function.BiPredicate<Integer[], Integer> subArrayWithSum = (input, sum) -> {

		for (int index = 0; index < input.length; index++) {

			int currentSum = 0;
			for (int sIndex = index; sIndex < input.length; sIndex++) {

				currentSum += input[sIndex];

				if (currentSum == sum)
					return true;
			}
		}
		return false;
	};

	// optimize solution
	public java.util.function.BiPredicate<Integer[], Integer> subArrayWithTarget = (input, target) -> {

		int currentSum = 0;
		int start = 0;
		for (int index = 0; index < input.length; index++) {

			currentSum += input[index];

			while (currentSum > target)
				currentSum -= input[start++];

			if (currentSum == target)
				return true;
		}
		return false;
	};

	public int getSum(int[] input, int start, int end) {

		int[] prefixSum = new int[input.length];

		prefixSum[0] = input[0];
		for (int index = 1; index < input.length; index++) {

			prefixSum[index] = prefixSum[index - 1] + input[index];
		}

		System.out.println(Arrays.toString(prefixSum));
		int result = getPrefixSumResult(prefixSum, start, end);
		return result;
	}

	private int getPrefixSumResult(int[] prefixSum, int i, int r) {

		if (i != 0) {

			return prefixSum[r] - prefixSum[i - 1];
		} else
			return prefixSum[r];
	}

	// o(n)2
	public java.util.function.Function<Integer[], Integer> findEquilibrium = (input) -> {

		for (int index = 0; index < input.length; index++) {

			int leftSum = 0;
			int rightSum = 0;

			for (int j = 0; j <= index; j++) {

				leftSum += input[j];
			}

			for (int k = index; k < input.length; k++) {

				rightSum += input[k];
			}
			if (leftSum == rightSum)
				return leftSum;
		}
		return -1;
	};

	// O(n)time/space
	public java.util.function.Function<Integer[], Integer> findEqui = (input) -> {

		int[] prefixSum = new int[input.length];
		prefixSum[0] = input[0];

		for (int index = 1; index < input.length; index++) {

			prefixSum[index] = prefixSum[index - 1] + input[index];
		}
		System.out.println(Arrays.toString(prefixSum));

		int le = prefixSum[prefixSum.length - 1];
		for (int index = 0; index < input.length; index++) {

			int leftSum = prefixSum[index] - input[index];
			int rightSum = le - prefixSum[index];

			if (leftSum == rightSum)
				return leftSum;
		}
		return -1;

	};

	public java.util.function.Predicate<Integer[]> findEq = (input) -> {

		int sum = 0;
		for (int index = 0; index < input.length; index++) {

			sum += input[index];
		}

		int leftSum = 0;

		for (int index = 0; index < input.length; index++) {

			if (leftSum == sum - input[index]) {

				return true;
			}

			leftSum += input[index];
			sum -= input[index];
		}
		return false;
	};

	public static void main(String... strings) {

		Array array = new Array();
//		Integer[] input = { 8, 3, 4, 8, 8 };
//		Integer[] input = { 3, 7, 4, 7, 7, 5 };
//		Integer[] input = { 20, 30, 40, 50, 50, 50, 50 };
//		int result = array.majorityElement.apply(input);
//		System.out.println(result);
//		array.mjrElement.accept(input);

//		Integer[] numbers = { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 };
//		array.miniumGroupToFlip.accept(numbers);

//		Integer[] input = { 1, 8, 30, -5, 20, 7 };
//		Integer[] input = { 5, -10, 6, 90, 3 };
//		int result = array.maxSumOfKthConsecutive.apply(input, 4);
//		System.out.println(result);
//
//		int res = array.maxSumKthConsec.apply(input, 4);
//		System.out.println(res);

		Integer[] input = { 1, 4, 20, 3, 10, 5 };
//		Integer[] input = { 1, 4, 0, 0, 3, 10, 5 };
//		Integer[] input = { 4, 8, 12, 5 };
//		int sum = 17;
//		boolean result = array.subArrayWithSum.test(input, sum);
//		System.out.println(result);
//
//		result = array.subArrayWithTarget.test(input, sum);
//		System.out.println(result);

//		int[] nums = { 2, 8, 3, 9, 6, 5, 4 };
//		int result = array.getSum(nums, 1, 2);
//		System.out.println(result);

		Integer[] numbers = { 3, 4, 8, -9, 20, 6 };
//		Integer[] numbers = { 4, 2, -2 };
//		Integer[] numbers = { 4, 2, 2 };
		int result = array.findEquilibrium.apply(numbers);
		System.out.println(result);

		result = array.findEqui.apply(numbers);
		System.out.println(result);
		boolean res = array.findEq.test(numbers);
		System.out.println(res);
	}
}
