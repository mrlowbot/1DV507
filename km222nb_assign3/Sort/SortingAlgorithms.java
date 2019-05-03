package km222nb_assign3.Sort;

import java.util.Comparator;

public class SortingAlgorithms {

	public static void main(String[] args) {
		SortingAlgorithms sa = new SortingAlgorithms();

		int[] arr = { 6, -7, 9, -12, 1, 32, 16, -1 };
		int[] sortedIntArr = sa.insertionSort(arr);

		System.out.println("Sorted int array: ");
		for (int i = 0; i < sortedIntArr.length; i++) {
			System.out.print(sortedIntArr[i] + " ");
		}

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		String[] stringArr = { "Why", "did", "the", "chicken", "cross", "the", "road", "?" };
		String[] sortedStringArr = sa.insertionSort(stringArr, c);

		System.out.println("\nSorted string array: ");
		for (int i = 0; i < sortedStringArr.length; i++) {
			System.out.println(sortedStringArr[i]);
		}
	}

	public int[] insertionSort(int[] in) {
		int[] newArr = new int[in.length];
		System.arraycopy(in, 0, newArr, 0, in.length);

		for (int i = 1; i < newArr.length; i++) {
			int temp = newArr[i];
			int pos = i;

			while (pos > 0 && newArr[pos - 1] > temp) {
				newArr[pos] = newArr[pos - 1];
				pos = pos - 1;
			}

			newArr[pos] = temp;
		}
		return newArr;
	}

	public String[] insertionSort(String[] in, Comparator<String> c) {
		String[] newArr = new String[in.length];
		System.arraycopy(in, 0, newArr, 0, in.length);

		for (int i = 1; i < newArr.length; i++) {
			String temp = newArr[i];
			int pos = i;

			while (pos > 0 && c.compare(newArr[pos - 1], temp) > 0) {
				newArr[pos] = newArr[pos - 1];
				pos = pos - 1;
			}

			newArr[pos] = temp;
		}
		return newArr;
	}
}