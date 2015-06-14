package sorting.quicksort;

import sorting.shuffle.Shuffle;

public class QuickSort {

	public static void quickSort(Comparable[] array) {
		Shuffle.shuffle(array);
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(Comparable[] array, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(array, lo, hi);
		quickSort(array, lo, j - 1);
		quickSort(array, j + 1, hi);
	}

	private static int partition(Comparable[] array, int lo, int hi) {
		int i = lo;
		int j = hi+1;
		while (true) {
			while (less(array[++i], array[lo])) {
				if (i == hi)
					break;
			}
			while (less(array[lo], array[--j])) {
				if (j == lo)
					break;
			}

			if (i >= j)
				break;

			exchange(array, i, j);
		}
		exchange(array, lo, j);
		return j;
		
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void exchange(Comparable[] array, int index1, int index2) {
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void print(Integer[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] array = { 1,2,3,4,6,5 };
		print(array);
		QuickSort.quickSort(array);
		print(array);
	}

}
