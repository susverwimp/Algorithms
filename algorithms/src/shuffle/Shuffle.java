package shuffle;

import java.util.Random;

public class Shuffle {

	public static void shuffle(Object[] array) {
		int length = array.length;

		Random random = new Random();
		for (int i = 1; i < length; i++) {
			int replace = random.nextInt(i + 1);
			exchange(array, replace, i);
		}
	}

	private static void exchange(Object[] array, int index1, int index2) {
		Object temp = array[index1];
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
		Integer[] array = { 1, 2, 3, 4, 5, 6 };
		print(array);
		Shuffle.shuffle(array);
		print(array);
	}

}
