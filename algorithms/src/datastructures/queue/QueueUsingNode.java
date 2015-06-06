package datastructures.queue;

public class QueueUsingNode<E> {

	private Node<E> first;
	private Node<E> last;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public void enqueue(E element){
		Node<E> oldLast = last;
		last = new Node<>();
		last.element = element;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldLast.next = last;
	}
	
	public E dequeue(){
		E element = first.element;
		first = first.next;
		if(isEmpty())
			last = null;
		return element;
	}
	
	private class Node<E>{
		E element;
		Node<E> next;
	}
	
	public static void main(String[] args){
		QueueUsingNode<Integer> stack = new QueueUsingNode<>();
		System.out.println(stack.isEmpty()); //true
		stack.enqueue(2);
		stack.enqueue(3);
		System.out.println(stack.isEmpty()); //false
		int i = stack.dequeue();
		System.out.println(i); //3
		i = stack.dequeue();
		System.out.println(i); //2
		System.out.println(stack.isEmpty()); //true
	}
	
}
