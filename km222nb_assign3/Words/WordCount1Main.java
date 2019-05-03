package km222nb_assign3.Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

	public static void main(String[] args) {

		Scanner scan1 = null;
		HashSet<Word> hash = new HashSet<Word>();
		TreeSet<Word> tree = new TreeSet<Word>();
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

			int count = 0;
			System.out.println("Tree Iterator: \n");

			Iterator<Word> it = tree.iterator();
			while (it.hasNext())
				System.out.println(++count + " " + it.next());

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

	}

}