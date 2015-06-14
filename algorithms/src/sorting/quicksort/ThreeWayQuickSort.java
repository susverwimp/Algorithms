package sorting.quicksort;

import sorting.shuffle.Shuffle;

public class ThreeWayQuickSort {

	public static void quickSort(Comparable[] array) {
		Shuffle.shuffle(array);
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(Comparable[] array, int lo, int hi) {
		if (hi <= lo)
			return;
		int lt = lo;
		int gt = hi;
		Comparable v = array[lo];
		int i = lo;
		while (i <= gt) {
			int cmp = array[i].compareTo(v);
			if (cmp < 0)
				exchange(array, lt++, i++);
			else if (cmp > 0)
				exchange(array, i, gt--);
			else
				i++;
		}
		quickSort(array, lo, lt - 1);
		quickSort(array, gt + 1, hi);
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
		Integer[] array = { 5, 5, 5, 9, 8, 3, 1, 5, 1, 2, 3, 7, 8, 9, 3, 66 };
		print(array);
		ThreeWayQuickSort.quickSort(array);
		print(array);
	}

}
