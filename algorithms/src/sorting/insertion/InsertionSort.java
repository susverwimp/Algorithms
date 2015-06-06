package sorting.insertion;

public class InsertionSort {
	
	public static void insertionSort(Comparable[] array){
		int length = array.length;
		//improvement, start with int i = 1, if i = 0, the there will never be any exchanges
		//for(int i = 1; i < length - 1; i++){
		for(int i = 0; i < length - 1; i++){
			
			for(int j = i; j > 0; j--){
				if(less(array[j], array[j-1]))
					exchange(array, j, j-1);
				else
					break;
			}
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
		InsertionSort.insertionSort(array);
		print(array);
	}

}
