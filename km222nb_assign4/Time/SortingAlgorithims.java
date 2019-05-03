package km222nb_assign4.Time;

import java.util.Comparator;
import java.util.Random;

public class SortingAlgorithims {

	public static void main(String[] args) {
		int[] arr = new int[1000];
		System.out.println("Sorted integers: " + measureInt(arr));

		Comparator<String> c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		String[] arr2 = new String[1000];
		System.out.println("Sorted strings: " + measureString(arr2, c));
	}

	public static int measureInt(int[] arr) {
		int counter = 0;
		boolean lessThanOneSecond = true;
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100000);
		}

		long stepBack = System.nanoTime();
		while (lessThanOneSecond) {
			insertionSort(arr);
			counter++;

			if (System.nanoTime() - stepBack <= 1000000000) {
				lessThanOneSecond = true;
			} else {
				lessThanOneSecond = false;
			}

			for (int j = 0; j < arr.length; j++) {
				arr[j] = r.nextInt(100000);
			}
		}
		return counter * 1000;
	}

	public static int measureString(String[] arr, Comparator<String> c) {
		int counter = 0;
		boolean lessThanOneSecond = true;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandomString();
		}

		long before = System.nanoTime();
		while (lessThanOneSecond) {
			insertionSort(arr, c);
			counter++;

			if (System.nanoTime() - before <= 1000000000) {
				lessThanOneSecond = true;
			} else {
				lessThanOneSecond = false;
			}

			for (int j = 0; j < arr.length; j++) {
				arr[j] = getRandomString();
			}
		}
		return counter * 1000;
	}

	public static String getRandomString() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		while (sb.length() < 11) {
			int index = r.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		return sb.toString();
	}

	public static int[] insertionSort(int[] in) {
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

	public static String[] insertionSort(String[] in, Comparator<String> c) {
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