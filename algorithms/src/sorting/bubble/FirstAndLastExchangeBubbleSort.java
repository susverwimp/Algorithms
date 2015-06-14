package sorting.bubble;

import datastructures.counter.Counter;

public class FirstAndLastExchangeBubbleSort {

	private static Counter exchangeCounter = new Counter("exchanges");
	private static Counter compareCounter = new Counter("compares");
	
	public static void bubbleSort(Comparable[] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			int lastExchangeIndex = 0;
			for (int j = 0; j < length - i - 1; j++) {
				if (less(array[j + 1], array[j])) {
					exchange(array, j, j + 1);
					lastExchangeIndex = j;
				}
			}
			i += (length - lastExchangeIndex);
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		compareCounter.increment();
		return a.compareTo(b) < 0;
	}

	private static void exchange(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		exchangeCounter.increment();
	}

	private static void print(Integer[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] array = { 5, 3, 1, 8, 6, 9 };
		print(array);
		FirstAndLastExchangeBubbleSort.bubbleSort(array);
		print(array);
		System.out.println(exchangeCounter);
		System.out.println(compareCounter);
	}

}
