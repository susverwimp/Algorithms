package datastructures.stack;

public class StackUsingFixedArray<E> {
	
	private E[] array;
	private int index = 0;
	
	public StackUsingFixedArray(int capacity){
		array = (E[]) new Object[capacity];
	}
	
	public boolean isEmpty(){
		return index == 0;
	}
	
	public void push(E element){
		array[index++] = element;
	}
	
	//TODO throw exception when pop from empty list
	public E pop(){
		E item = array[--index];
		array[index] = null;
		return item;
	}
	
	public static void main(String[] args){
		StackUsingFixedArray<Integer> stack = new StackUsingFixedArray<>(3);
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
