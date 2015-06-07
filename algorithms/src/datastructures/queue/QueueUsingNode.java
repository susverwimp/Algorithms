package datastructures.queue;

import java.util.Iterator;

public class QueueUsingNode<E> implements Iterable<E> {

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
	
	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
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
		QueueUsingNode<Integer> queue = new QueueUsingNode<>();
		System.out.println(queue.isEmpty()); //true
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.isEmpty()); //false
		for(Integer i : queue){ //iterates over the queue and print 2 and then 3
			System.out.println(i);
		}
		System.out.println(queue.dequeue()); //3
		System.out.println(queue.dequeue()); //2
		System.out.println(queue.isEmpty()); //true
		
	}
}
