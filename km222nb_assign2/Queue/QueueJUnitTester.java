package km222nb_assign2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.*;

public class QueueJUnitTester {
	private static int test_count = 0;

	/* Is executed before every test method (not test case). */
	@Before
	public void setUp() {
		test_count++;
		System.out.println("Test " + test_count);
	}

	/* Is executed after every test method (not test case). */
	@After
	public void tearDown() {
	}

	/* Check size */
	@Test
	public void testInitSize() {
		/* Empty */
		Queue queue = new LinkedQueue();

		assertEquals(0, queue.size());

		/* Filled */
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
		}

		assertEquals(1000, queue.size());

	}

	/* Check isEmpty */
	@Test
	public void testIsEmpty() {
		/* Empty */
		Queue queue = new LinkedQueue();

		assertEquals(true, queue.isEmpty());

		/* Not Empty */
		queue.enqueue(100);

		assertEquals(false, queue.isEmpty());

	}

	/* Check Enqueue */
	@Test
	public void testEnqueue() {
		/* Add Object At Last Position */
		Queue queue = new LinkedQueue();

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);

			assertEquals(i, queue.last()); /* Check */

		}

		/* Check First Element */
		assertEquals(0, queue.first());

	}

	/* Check Dequeue */
	@Test
	public void testDequeue() {
		/* Add 10 Objects */
		Queue queue = new LinkedQueue();

		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);

		}

		/* Remove The Object One By One */
		for (int i = 0; i < 10; i++) {
			assertEquals(i, queue.dequeue()); /* Check */

		}

		/* New Queue For Testing If Queue IsEmpty */
		Queue queue1 = new LinkedQueue();

		boolean res1 = false;
		try {
			queue1.dequeue();

		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

	/* Check First Object */
	@Test
	public void testObjectFirst() {
		/* Add 5 Objects */
		Queue queue = new LinkedQueue();

		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);

		}

		assertEquals(0, queue.first()); /* Check */

		/* New Queue With Only 1 Element */
		Queue queue1 = new LinkedQueue();

		queue1.enqueue(100);

		assertEquals(100, queue1.first()); /* Check */

		/* New Queue For Testing If Queue IsEmpty */
		Queue queue2 = new LinkedQueue();

		boolean res1 = false;
		try {
			queue2.first();

		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

	/* Check First Object */
	@Test
	public void testObjectLast() {
		/* Add 5 Objects */
		Queue queue = new LinkedQueue();

		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);

			assertEquals(i, queue.last()); /* Check */

		}

		/* New Queue With Only 1 Element */
		Queue queue1 = new LinkedQueue();

		queue1.enqueue(100);

		assertEquals(100, queue1.last()); /* Check */

		/* New Queue For Testing If Queue IsEmpty */
		Queue queue2 = new LinkedQueue();

		boolean res1 = false;
		try {
			queue2.last();

		} catch (NoSuchElementException e) {
			res1 = true;
		}
		assertTrue(res1);
	}

	/* Check String */
	@Test
	public void testString() {
		/* Empty Queue */
		Queue queue = new LinkedQueue();

		String str = "[ ]";
		assertEquals(str, queue.toString());

		/* Filled Queue */
		Queue queue1 = new LinkedQueue();

		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < 5; i++) {
			queue1.enqueue(i);

			s.append(" " + i);
		}
		s.append(" ]");
		assertEquals(s.toString(), queue1.toString());

		/* Remove Element From Queue */
		for (int i = 0; i < 4; i++) {
			queue1.dequeue();

		}
		String ss = "[ 4 ]";
		assertEquals(ss, queue1.toString());
	}

	/* Check Iterator */
	@Test
	public void testIterator() {
		/* Filled Queue */
		Queue queue = new LinkedQueue();

		Iterator<Object> que = queue.iterator();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);

			while (que.hasNext()) {
				assertEquals(i, que.next());
			}
		}
	}
}