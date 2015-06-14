package datastructures.counter;

public class Counter {

	private int count;
	private String id;

	public Counter(String id) {
		this.id = id;
	}

	public void increment() {
		count++;
	}

	@Override
	public String toString() {
		return id + ": " + count;
	}

}
