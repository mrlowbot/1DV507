package km222nb_assign3.Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	public static void main(String[] args) {

		Scanner scan1 = null;
		HashWordSet hash = new HashWordSet();
		TreeWordSet tree = new TreeWordSet();
		String read = "";
		String path = "/Users/karwa/Desktop/words.txt";

		try {
			File file = new File(path);
			scan1 = new Scanner(file);
			while (scan1.hasNext()) {
				read = scan1.next();
				Word word = new Word(read);

				tree.add(word);
				hash.add(word);
			}
			scan1.close();

			System.out.println("Tree size: " + tree.size());
			System.out.println("Hash size: " + hash.size() + "\n");

			System.out.println("Tree toString: " + tree.toString());
			System.out.println("Hash toString: " + hash.toString() + "\n");

			Word hashWord = new Word("adopted");
			Word treeWord = new Word("adopted");

			System.out.println("Hash set contains \"" + hashWord + "\"" + ": " + hash.contains(hashWord));
			System.out.println("Tree set contains \"" + treeWord + "\"" + ": " + tree.contains(treeWord) + "\n");

			System.out.println("Iterator: ");

			int count = 0;
			Iterator<Word> it = tree.iterator();

			while (it.hasNext())
				System.out.println(++count + "  " + it.next());

		}

		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}
}