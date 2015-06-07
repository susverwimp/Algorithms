package sorting.merge;

public class MergeSort {

	public static void mergeSort(Comparable[] array) {
		Comparable[] aux = new Comparable[array.length];
		mergeSort(array, aux, 0, array.length - 1);
	}

	public static void mergeSort(Comparable[] array, Comparable[] aux, int lo,
			int hi) {
		if (hi <= lo) // stop the recursive
			return;
		int mid = lo + (hi - lo) / 2; // find the middle of the array, automatic
										// Math.floor by int
		mergeSort(array, aux, lo, mid); // mergesort the left part recursively
		mergeSort(array, aux, mid + 1, hi); // mergesort the right part
											// recursively
		// improvement: only merge when last element of the left is less greater
		// than first of the right
		if (!less(array[mid], array[mid + 1]))
			merge(array, aux, lo, mid, hi);
	}

	public static void merge(Comparable[] array, Comparable[] aux, int lo,
			int mid, int hi) {
		for (int i = lo; i <= hi; i++)
			// copy the array to aux
			aux[i] = array[i];
		int i = lo; // merge
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) //optimization, just break the for loop because we copied the array to the auxiliary array
				array[k] = aux[j++];
			else if (j > hi)
				array[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				array[k] = aux[j++];
			else
				array[k] = aux[i++];
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void print(Integer[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// switch to insertion sort for small arrays, to much overhead with
		// merge sort
		Integer[] array = { 5, 3, 1, 8, 6, 9 };
		print(array);
		MergeSort.mergeSort(array);
		print(array);
	}

}
