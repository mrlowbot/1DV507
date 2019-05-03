package km222nb_assign4.Heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryIntHeapTester {

	private static int test_count = 0;

	@BeforeEach
	public void setup() {
		test_count++;
		System.out.println("Test " + test_count);
	}

	@Test
	public void testIsEmpty() {
		BinaryIntHeap heap = new BinaryIntHeap();
		assertTrue(heap.isEmpty());
		heap.insert(5);
		assertFalse(heap.isEmpty());
	}

	@Test
	public void testSize() {
		BinaryIntHeap heap = build();
		assertEquals(6, heap.size());
		heap.pullHighest();
		heap.pullHighest();
		assertEquals(4, heap.size());
	}

	@Test
	public void testPullHighest() {
		BinaryIntHeap heap = build();
		assertEquals(90, heap.pullHighest());
		assertEquals(15, heap.pullHighest());
		assertEquals(12, heap.pullHighest());
		assertEquals(10, heap.pullHighest());
		assertEquals(7, heap.pullHighest());
		assertEquals(1, heap.size());
	}

	@Test
	public void testInsert() {
		BinaryIntHeap heap = build();
		heap.insert(100);
		assertEquals(7, heap.size());
		assertEquals(100, heap.pullHighest());
	}

	private BinaryIntHeap build() {
		BinaryIntHeap heap = new BinaryIntHeap();
		heap.insert(90);
		heap.insert(15);
		heap.insert(10);
		heap.insert(7);
		heap.insert(12);
		heap.insert(2);
		return heap;
	}
}