package km222nb_assign2.Queue;

import java.util.Iterator;

/**
 * This is an interface with methods for a Queue. It can access the values at
 * the first and last position without removing the element. It can tell us the
 * size of this Queue and whether it is empty or not. We call also iterate
 * throughout the Queue, and as such we can also get the string with all the
 * elements within the Queue. Lastly we can add elements to the end of our
 * Queue.
 * 
 * @author Karwan
 */
public interface Queue {

	/**
	 * Current number of elements within the Queue.
	 * 
	 * @return Integer
	 */

	public int size();

	/**
	 * Checks whether the the Queue is empty or not.
	 * 
	 * @return Boolean
	 */

	public boolean isEmpty();

	/**
	 * Adds an object at the end of the Queue.
	 * 
	 * @param element
	 */
	public void enqueue(Object element);

	/**
	 * Returns and deletes the first object within the Queue.
	 * 
	 * @return Object
	 */

	public Object dequeue();

	/**
	 * Returns the first Object without removing it from the Queue.
	 * 
	 * @return Object
	 */

	public Object first();

	/**
	 * Returns the last Object without removing it from the Queue.
	 * 
	 * @return Object
	 */

	public Object last();

	/**
	 * Returns a String representation of the Queue.
	 * 
	 * @return String
	 */

	public String toString();

	/**
	 * Iterates over the element/elements within the Queue.
	 * 
	 * @return Iterator
	 */

	public Iterator<Object> iterator();
}