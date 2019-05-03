package km222_nb_assign1;

import java.io.*;

/*Not sure of how you guys would test for this... but yeah it work for me haha.
 * No but i think that you will test the map of all of my files. 
 */

public class PrintJavaMain {

	public static void main(String[] args) throws IOException {
		try {
			File file = new File("C:\\Users\\karwa\\Desktop\\1DV507\\src\\km222_nb_assign1");
			printAllJavaFiles(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int depth = 1, count = 0;

	public static void printAllJavaFiles(File file) throws IOException {
		if (file.isDirectory()) {
			System.out.println((++count) + indentation() + file.getName());
			depth++;
			File[] subs = file.listFiles();
			for (File f : subs) {
				printAllJavaFiles(f);
			}
			depth--;
		} else if (file.isFile()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int rows = 0;
			while (reader.readLine() != null) {
				rows++;
			}
			reader.close();
			System.out.println((++count) + indentation() + file.getName() + " (" + rows + " rows)");
		}
	}

	public static String indentation() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}