package datastructures.stack;

import java.util.Iterator;

//use this when you want a fast stack with constant time for each operation even in the worst case
public class StackUsingNode<E> implements Iterable<E> {
	
	private Node<E> first = null;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void push(E element){
		Node<E> oldFirst = first;
		first = new Node<E>();
		first.element = element;
		first.next = oldFirst;
	}
	
	public E pop(){
		E element = first.element;
		first = first.next;
		return element;
	}
	

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private class Node<E>{
		E element;
		Node<E> next;
	}
	
	private class ListIterator implements Iterator<E>{

		private Node<E> current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E element = current.element;
			current = current.next;
			return element;
		}
	}
	
	
	public static void main(String[] args){
		StackUsingNode<Integer> stack = new StackUsingNode<>();
		System.out.println(stack.isEmpty()); //true
		stack.push(2);
		stack.push(3);
		System.out.println(stack.isEmpty()); //false
		for(int i : stack){ //iterates over the stack and print 3 and then 2
			System.out.println(i);
		}
		System.out.println(stack.pop()); //3
		System.out.println(stack.pop()); //2
		System.out.println(stack.isEmpty()); //true
	}

	
	
}
