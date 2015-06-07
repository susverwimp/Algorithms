package sorting.merge;

public class BottomUpMergeSort {
	
	public static void mergeSort(Comparable[] array){
		int length = array.length;
		Comparable[] aux = new Comparable[length];
		for(int sz = 1; sz < length; sz*=2){
			for(int lo = 0; lo<length-sz; lo+=sz+sz){
				merge(array, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, length-1));
			}
		}
	}
	
	public static void merge(Comparable[] array, Comparable[] aux, int lo,
			int mid, int hi) {
		for (int i = lo; i <= hi; i++)
			// copy the array to aux
			aux[i] = array[i];
		int i = lo; // merge
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
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
		BottomUpMergeSort.mergeSort(array);
		print(array);
	}

}
