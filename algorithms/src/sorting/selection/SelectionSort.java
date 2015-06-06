package sorting.selection;

public class SelectionSort {

	public static void selectionSort(Comparable[] array) {
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			int min = i;
			for(int j = i+1; j < length; j++){
				if(less( array[j], array[min])){
					min = j;
				}
			}
			exchange(array, i, min);
		}
	}
	
	private static boolean less(Comparable a, Comparable b){
		return a.compareTo(b) < 0;
	}
	
	private static void exchange(Comparable[] array, int index1, int index2){
		Comparable temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private static void print(Integer[] array){
		for(int i : array){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		Integer[] array = {5,3,1,8,6,9};
		print(array);
		SelectionSort.selectionSort(array);
		print(array);
	}

}
