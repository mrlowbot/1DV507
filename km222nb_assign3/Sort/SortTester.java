package km222nb_assign3.Sort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class SortTester {
	private static int test_count = 0;

	@BeforeEach
	public void setup() {
		test_count++;
		System.out.println("Test: " + test_count);
	}

	@Test
	public void testInsertionSortInt() {
		SortingAlgorithms s = new SortingAlgorithms();
		int[] arr = { 32, 2, 4, 64, 1, 98, 5 };
		int[] sortedArr = s.insertionSort(arr);

		assertEquals(arr.length, sortedArr.length);

		for (int i = 0; i < sortedArr.length - 1; i++) {
			assertTrue(sortedArr[i] <= sortedArr[i + 1]);
		}
	}

	@Test
	public void testInsertionSortString() {
		SortingAlgorithms s = new SortingAlgorithms();
		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		String[] arr = { "Sort", "tesing", "tester", "1", "2", "3" };
		String[] sortedArr = s.insertionSort(arr, c);

		assertEquals(arr.length, sortedArr.length);

		for (int i = 0; i < sortedArr.length - 1; i++) {
			assertTrue(c.compare(sortedArr[i], sortedArr[i + 1]) < 0); // Check if ascending order
		}
	}
}
