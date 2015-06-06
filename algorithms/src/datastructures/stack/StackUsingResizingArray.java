package datastructures.stack;

//use this when you want a better memory efficient datastructure with constant amortized time for each operation
public class StackUsingResizingArray<E> {

	private E[] array;
	private int index = 0;

	public StackUsingResizingArray(int initialCapacity) {
		array = (E[]) new Object[initialCapacity];
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void push(E element) {
		if (index == array.length)
			resize(2 * index);
		array[index++] = element;
	}

	// TODO throw exception when pop from empty list
	public E pop() {
		E item = array[--index];
		array[index] = null;
		if (index > 0 && index == array.length / 4) // when array is a quarter filled, resize it to half
			resize(array.length / 2);
		return item;
	}

	private void resize(int capacity) {
		E[] copy = (E[]) new Object[capacity];
		for (int i = 0; i < index; i++) {
			copy[i] = array[i];
		}
		array = copy;
	}
	
	public static void main(String[] args){
		StackUsingResizingArray<Integer> stack = new StackUsingResizingArray<>(1);
		System.out.println(stack.isEmpty()); //true
		stack.push(2);
		stack.push(3);
		System.out.println(stack.isEmpty()); //false
		int i = stack.pop();
		System.out.println(i); //3
		i = stack.pop();
		System.out.println(i); //2
		System.out.println(stack.isEmpty()); //true
	}
}
