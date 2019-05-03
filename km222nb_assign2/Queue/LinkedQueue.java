package km222nb_assign2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class has the methods from "Queue" (this class implements Queue). It is
 * supposed to act as a linked Queue.
 * 
 * 
 * @author Karwan
 *
 */

public class LinkedQueue implements Queue {

	// Private fields.
	private int Size = 0;
	private node Head = null;
	private node Tail = null;

	/**
	 * Constructor for our class. This is left empty and therefore is an empty
	 * linked Queue.
	 */

	public LinkedQueue() {

	}

	/**
	 * This is a private class which we called node. Our node class is here to refer
	 * to an element in the Queue. Note: The word "node" seemed more appropriate as
	 * a class name then "a point (our case element) within a "list" of something".
	 */

	private class node {
		// More fields.
		private Object ourData;
		private node next;
	}

	/**
	 * Simply returns the size of the Queue.
	 */

	@Override
	public int size() {
		return Size;
	}

	/**
	 * Returns true if Queue is empty. Returns false if the Queue isn't empty.
	 */

	@Override
	public boolean isEmpty() {
		return Head == null;
	}

	/**
	 * Put in Object at the last position in the Queue.
	 * 
	 * @param element
	 */

	@Override
	public void enqueue(Object element) {

		/**
		 * Is the Queue empty? Then we add the element first.
		 * 
		 * Is the Queue not empty? Then we add the element next to our Tail and change
		 * the position of our Tail which will represent the new element which has been
		 * added.
		 * 
		 * The size of our Queue will increase in either case.
		 */

		if (isEmpty() == true) {
			node nextNode = new node();
			nextNode.ourData = element;
			Head = nextNode;
			Tail = Head;
		} else {
			node nextNode = new node();
			nextNode.ourData = element;
			Tail.next = nextNode;
			Tail = Tail.next;
		}

		Size++;
	}

	/**
	 * Returns and removes the Object at the first position of our Queue. Throws
	 * "NoSuchElementException" if the Queue happen to be empty.
	 */
	@Override
	public Object dequeue() {

		/**
		 * Empty? Throw exception. Otherwise just remove and return the first element
		 * and change the Head node next to this element. Also decrease the size.
		 */

		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}

		Object element = Head.ourData;
		Head = Head.next;
		Size--;
		return element;
	}

	/**
	 * Returns the Object in the first position within the Queue. Throws
	 * "NoSuchElementException" if the Queue happen to be empty.
	 */
	@Override
	public Object first() {
		/*
		 * Empty? If so Throw exception otherwise just return the first element!
		 */

		if (Head == null) {
			throw new NoSuchElementException();
		} else
			return Head.ourData;
	}

	/**
	 * Returns the Object in the last position within the Queue. Throws
	 * "NoSuchElementException" if the Queue happen to be empty.
	 */
	@Override
	public Object last() {
		/*
		 * Empty? If so Throw exception otherwise just return the last element!
		 */
		if (Tail == null) {
			throw new NoSuchElementException();
		} else
			return Tail.ourData;
	}

	/**
	 * Returns the elements in the Queue in a String form.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		/*
		 * Returns everything in String form. If empty then return an empty Queue.
		 */

		StringBuilder str = new StringBuilder();
		node newNode = new node();
		newNode = Head;
		str.append("[");
		while (newNode != null) {
			str.append(" " + newNode.ourData);
			newNode = newNode.next;
		}
		str.append(" ]");
		return str.toString();
	}

	/*
	 * Goes throughout all the elements in the Queue.
	 * 
	 * @Iterator
	 */
	@Override
	public Iterator<Object> iterator() {

		return new LinkedQueueIterator();
	}
	//An inner Iterator!
	private class LinkedQueueIterator implements Iterator<Object> {
		private node position;
		public LinkedQueueIterator() {
			position = null;

		}

		/**
		 * Return true until the iterator does reached up to last Object of the queue.
		 * 
		 * @return boolean
		 */

		@Override
		public boolean hasNext() {

			/*
			 * In the beginning, position is null, so this method will return true only if
			 * Queue is not empty, otherwise false. In other case, position is increasing by
			 * 1, this method will return true until position is not reached up to the tail.
			 */

			if (position == null) {
				return Head != null;
			} else
				return position.next != null;

		}

		/**
		 * This method return Object until the hasnNext() method is true.
		 * 
		 * @return Object
		 */

		@Override
		public Object next() {

			/*
			 * Throw error if iterator already runs over all the elements in the Queue. In
			 * the first case, this method will only run if above method is true. In the
			 * last case, it will return elements until the position will not reached up to
			 * the tail.
			 */

			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (position == null) { //
				position = Head;
			} else {
				position = position.next;
			}
			return position.ourData;

		}

	}

}
