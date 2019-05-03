package km222nb_assign4.Time;

public class ConC {

	public static void main(String[] args) {

		String shortConcat = "";
		StringBuilder shortAppend = new StringBuilder();
		long numberOfShortConcat = 0;
		long numberOfShortAppend = 0;

		String longConcat = "";
		StringBuilder longAppend = new StringBuilder();
		long numberOfLongConcat = 0;
		long numberOfLongAppend = 0;

		long before = System.nanoTime();
		// Short ConC
		while (System.nanoTime() - before <= 1000000000) {
			shortConcat = shortConcat + "a";
			numberOfShortConcat++;
		}

		// Long ConC
		before = System.nanoTime();
		while (System.nanoTime() - before <= 1000000000) {
			longConcat = longConcat + "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
			numberOfLongConcat++;
		}

		// Short append
		before = System.nanoTime();
		while (System.nanoTime() - before <= 1000000000) {
			shortAppend.append("a").toString();
			numberOfShortAppend++;
		}

		// Long append
		before = System.nanoTime();
		while (System.nanoTime() - before <= 1000000000) {
			longAppend.append("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk").toString();
			numberOfLongAppend++;
		}

		System.out.println("Short concat: " + shortConcat.length());
		System.out.println("Number of short concatenations: " + numberOfShortConcat + "\n");

		System.out.println("Long concat: " + longConcat.length());
		System.out.println("Number of long concatenations: " + numberOfLongConcat + "\n");

		System.out.println("Short append: " + shortAppend.length());
		System.out.println("Number of short appends: " + numberOfShortAppend + "\n");

		System.out.println("Long append: " + longAppend.length());
		System.out.println("Number of long appends: " + numberOfLongAppend);
	}
}