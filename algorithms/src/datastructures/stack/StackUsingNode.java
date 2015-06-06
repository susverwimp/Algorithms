package datastructures.stack;


//use this when you want a fast stack with constant time for each operation even in the worst case
public class StackUsingNode<E> {
	
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

	private class Node<E>{
		E element;
		Node<E> next;
	}
	
	public static void main(String[] args){
		StackUsingNode<Integer> stack = new StackUsingNode<>();
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
