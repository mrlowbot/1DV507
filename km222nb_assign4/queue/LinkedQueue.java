package km222nb_assign4.queue;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void enqueue(T t) {
		if (head == null) {
			head = new Node(t);
			tail = head;
		} else {
			tail.next = new Node(t);
			tail = tail.next;
		}
		size++;
	}

	public T dequeue() {
		if (!isEmpty()) {
			Node first = head;
			Node peke = head.next;
			head = null;
			head = peke;
			size--;
			return first.value;
		}
		throw new EmptyStackException();
	}

	public T first() {
		if (!isEmpty()) {
			return head.value;
		} 
		throw new EmptyStackException();
	}

	public T last() {
		if (!isEmpty()) {
			return tail.value;
		}
		throw new EmptyStackException();
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("[");
		Node node = head;
		while (node != null) {
			buf.append(" " + node.value);
			node = node.next;
		}
		buf.append(" ]");
		return buf.toString();
	}

	public Iterator<T> iterator() {
		return new NodeIterator();
	}

	class NodeIterator implements Iterator<T> {
		private Node node = head;

		public T next() {
			T val = node.value;
			node = node.next;
			return val;
		}

		public boolean hasNext() {
			return node != null;
		}

		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}

	private class Node {
		T value;
		Node next = null;

		Node(T v) {
			value = v;
		}
	}
}