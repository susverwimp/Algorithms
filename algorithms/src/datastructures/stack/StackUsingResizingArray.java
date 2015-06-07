package datastructures.stack;

import java.util.Iterator;

//use this when you want a better memory efficient datastructure with constant amortized time for each operation
public class StackUsingResizingArray<E> implements Iterable<E> {

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
		if (index > 0 && index == array.length / 4) // when array is a quarter
													// filled, resize it to half
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

	@Override
	public Iterator<E> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<E> {

		private int i = index;

		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public E next() {
			return array[--i];
		}
	}

	public static void main(String[] args) {
		StackUsingResizingArray<Integer> stack = new StackUsingResizingArray<>(
				1);
		System.out.println(stack.isEmpty()); // true
		stack.push(2);
		stack.push(3);
		System.out.println(stack.isEmpty()); // false
		for(int i : stack){ //iterates over the stack and print 3 and then 2
			System.out.println(i);
		}
		System.out.println(stack.pop()); // 3
		System.out.println(stack.pop()); // 2
		System.out.println(stack.isEmpty()); // true
	}
}
