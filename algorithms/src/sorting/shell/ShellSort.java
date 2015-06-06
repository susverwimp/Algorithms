package sorting.shell;

public class ShellSort {

	public static void shellSort(Comparable[] array) {
		int length = array.length;

		// heuristics for computing with shellSort
		// x^2, bad because all odd parts of the array can not be checked if
		// they are sorted
		// (x^2) - 1, better but still not that good
		// 3x - 1, better but not the best
		int h = 1;
		while (h < length / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364,...

		while (h >= 1) {
			for (int i = h; i < length; i++) {	//h-sorting the list, it uses insertion sort with h as the gap for comparisons
				for (int j = i; j >= h; j -= h) {
					if (less(array[j], array[j - h]))
						exchange(array, j, j - h);
				}
			}
			h = h / 3; //minus 1 is included when converting to int
		}
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
		Integer[] array = { 5, 3, 1, 8, 6, 9 };
		print(array);
		ShellSort.shellSort(array);
		print(array);
	}

}
