package radixsort;

import java.util.LinkedList;
import java.util.Queue;

public class Radix {
	
	public static int[] radixSort(int[] input) {
		// Largest place for a 32-bit int is the 1 billion's place
		for (int place = 1; place <= 1000000000; place *= 10) {
			input = countingSort(input, place);
		}

		return input;
	}

	// countsort
	private static int[] countingSort(int[] input, int place) {
		int[] out = new int[input.length];
		Queue[] bucket = new Queue[10];

		for (int i = 0; i < 10; i++) {
			bucket[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < input.length; i++) {
			int digit = getDigit(input[i], place);
			bucket[digit].offer(input[i]);
		}

		int i = 0;
		int idx = 0;
		while (idx < 10) {
			if (bucket[i].size() != 0) {
				out[idx++] = (int) bucket[i].poll();
			} else {
				i++;
			}
		}
		return out;
	}

	private static int getDigit(int value, int digitPlace) {
		return ((value / digitPlace) % 10);
	}

	static void displayArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}