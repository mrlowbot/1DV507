package km222nb_assign4.queue;

import org.junit.jupiter.api.BeforeEach;

/*
 * I had my problems with the "Queue" as you may be able to see down below. Everything with that word has a yellow mark under it. 
 * Been trying to figure out why it does that but it just won't work any other way.
 * But in this way it still works fine. 
 */
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueue {

	private static int count = 0;

	@BeforeEach
	public void SetUp() {
		count++;
		System.out.println("Test " + count);
	}

	@Test
	public void testSize() {

		Queue q = build(3);
		assertEquals(3, q.size());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		assertEquals(0, q.size());

		Queue q1 = buildString();
		assertEquals(5, q1.size());
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		assertEquals(2, q1.size());
	}

	@Test
	public void testIsEmpty() {
		Queue q = build(3);
		assertEquals(false, q.isEmpty());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		assertEquals(true, q.isEmpty());

		Queue q1 = buildString();
		assertEquals(false, q1.isEmpty());
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		assertEquals(true, q1.isEmpty());
	}

	@Test
	public void testEnqueueAndLast() {
		Queue q1 = build(5);
		assertEquals(5, q1.size());

		Queue q2 = build(15);
		assertEquals(15, q2.size());

		assertEquals(4, q1.last());
		assertEquals(14, q2.last());

		Queue q3 = build(0);
		assertThrows(EmptyStackException.class, () -> q3.last());

		Queue q4 = buildString();
		assertEquals(5, q4.size());
		assertEquals("!", q4.last());
	}

	@Test
	public void testDequeue() {
		Queue q1 = build(5);
		assertEquals(0, q1.dequeue());

		Queue q2 = build(100);
		assertEquals(0, q2.dequeue());

		q2.dequeue();
		assertEquals(2, q2.dequeue());
		assertEquals(97, q2.size());

		Queue q3 = build(0);
		assertThrows(EmptyStackException.class, () -> q3.dequeue());

		Queue q4 = buildString();
		assertEquals("this", q4.dequeue());
		assertEquals("is", q4.dequeue());
		assertEquals(3, q4.size());
	}

	@Test
	public void testFirst() {
		Queue q1 = build(10);
		assertEquals(0, q1.first());

		q1.dequeue(); // Remove 0
		q1.dequeue(); // Remove 1
		q1.dequeue(); // Remove 2

		assertEquals(3, q1.first());
		assertEquals(7, q1.size());

		Queue q2 = build(0);
		assertThrows(EmptyStackException.class, () -> q2.first());

		Queue q3 = buildString();
		assertEquals("this", q3.first());
		q3.dequeue();
		q3.dequeue();
		q3.dequeue();

		assertEquals("test", q3.first());
		assertEquals(2, q3.size());
	}

	@Test
	public void testIterator() {
		Queue q = build(20);
		Iterator<Integer> it = q.iterator();
		int counter = 0;
		assertTrue(it.hasNext());
		while (it.hasNext()) {
			Object val = it.next();
			assertEquals(counter, val);
			counter++;
		}

		Queue<Integer> q1 = new LinkedQueue();
		Iterator<Integer> it2 = q1.iterator();
		assertFalse(it2.hasNext());
		assertThrows(NullPointerException.class, () -> it2.next());
	}

	/*
	 * Private method to facilitate tests
	 */
	private Queue build(int size) {
		Queue<Integer> queue = new LinkedQueue();
		for (int i = 0; i < size; i++) {
			queue.enqueue(i);
		}
		return queue;
	}

	private Queue buildString() {
		Queue<String> queue = new LinkedQueue();
		queue.enqueue("Testing");

		return queue;
	}

}