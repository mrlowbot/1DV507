package km222nb_assign3.Words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IdentyfyWordsMain {

	private static String read = "";
	private static String str;
	private static String readFilePath;
	private static File file;

	public static void main(String[] args) {

		readFilePath = "/Users/karwa/Desktop/HH.txt";

		readFile(readFilePath); 

	}

	public static void readFile(String path) {

		try {
		
			file = new File(path);

			Scanner scan = new Scanner(file); 

			while (scan.hasNextLine()) { 

		
				str = scan.nextLine() + "\n";

				for (int i = 0; i < str.length(); i++) {
					char c = str.charAt(i);

		
					if (Character.isLetter(c) || Character.isWhitespace(c)) {
						read = read + c;
					}
		
					else if (c == '-')
						read = read + " ";
				}
			}

			writeFile();
			System.out.println("Your file has been succesfully read and created. You can find your new file at: "
					+ file.getParentFile() + "/words.txt");
			scan.close();
		}
	
		catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	
	private static void writeFile() throws IOException {
		File file1 = new File(file.getParentFile() + "/words.txt");
		file1.createNewFile();
		PrintWriter printer = new PrintWriter(file1);
		printer.print(read);
		printer.close();
	}

}