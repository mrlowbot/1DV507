package km222_nb_assign1;

public class PrintRecursive {

	// Note that i was unsure of if this was the way that you guys wanted it.
	// If you wanted each letter within the string or not... didn't ask.

	public static void main(String[] args) {

		String str = "Hello Everyone!";
		print(str, 0);
		System.out.println(); // Line break
		printReverse(str, 14); // Amount of characters that you wanted to be printed backwards.
	}

	// Both methods work almost in the same way but one goes backwards.
	private static void print(String s, int i) {
		if (i == s.length() - 1)
			System.out.println(s.charAt(i));
		else {
			System.out.print(s.charAt(i));
			print(s, i + 1);
		}
	}

	// This method could've been done in the other way around so that when the input
	// is 0 and the whole string gets printed out in the other way around.
	// But this works aswell.
	private static void printReverse(String s, int i) {
		if (i == 0)
			System.out.println(s.charAt(i));
		else {
			System.out.print(s.charAt(i));
			printReverse(s, i - 1); // If int is > than 0 then we start to print out the next char that is within
									// the string.
		}
	}
}
