package datastructures.stack;

import java.util.Iterator;

public class StackUsingFixedArray<E> implements Iterable<E> {

	private E[] array;
	private int index = 0;

	public StackUsingFixedArray(int capacity) {
		array = (E[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void push(E element) {
		array[index++] = element;
	}

	// TODO throw exception when pop from empty list
	public E pop() {
		E item = array[--index];
		array[index] = null;
		return item;
	}

	@Override
	public Iterator<E> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<E> {

		private int i = index;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public E next() {
			return array[--i];
		}
	}

	public static void main(String[] args) {
		StackUsingFixedArray<Integer> stack = new StackUsingFixedArray<>(3);
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
