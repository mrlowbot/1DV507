package km222nb_assign3.Words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {


	private BST root = null;
	private int size;
	private StringBuilder str = new StringBuilder();
	private Word[] arr = new Word[8];
	private int count = 0;

	private class BST {


		private Word word;
		private BST left = null;
		private BST right = null;

		public BST(Word word) {
			this.word = word;

		}

		private void add(Word word) {
			if (word.compareTo(this.word) < 0) {
				if (left == null) {
					left = new BST(word);
					size++;
				} else
					left.add(word);

			} else if (word.compareTo(this.word) > 0) {
				if (right == null) {
					right = new BST(word);
					size++;
				} else
					right.add(word);

			}

		}

		private boolean contains(Word word) {
			if (word.compareTo(this.word) < 0) {
				if (left == null)
					return false;
				else
					return left.contains(word);
			}

			else if (word.compareTo(this.word) > 0) {
				if (right == null)
					return false;
				else
					return right.contains(word);
			}
			return true;
		}

		private String print() {

			if (left != null)
				left.print();

			str.append(word + " ");

			if (right != null)
				right.print();

			return str.toString();
		}

		private Word[] getWordArray() {
			if (left != null)
				left.getWordArray();

			if (count == arr.length)
				resize();
			arr[count] = word;
			count++;
			if (right != null)
				right.getWordArray();

			return arr;
		}

	}

	public TreeWordSet() {
		size = 0;

	}

	@Override
	public Iterator<Word> iterator() {
		return new TreeWordSetIterator();
	}

	@Override
	public void add(Word word) {
		if (root == null) {
			root = new BST(word);
			size++;

		} else {
			root.add(word);

		}

	}

	@Override
	public boolean contains(Word word) {
		if (size == 0)
			return false;
		else
			return root.contains(word);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		if (root != null)
			return "[ " + root.print() + " ]";
		else
			return "[ ]";

	}

	private void resize() {
		Word[] temp = new Word[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		arr = temp;
	}

	private class TreeWordSetIterator implements Iterator<Word> {

		private int count = 0;


		public TreeWordSetIterator() {
			root.getWordArray(); 
		}

		public boolean hasNext() {
			if (root == null)
				return false;
			else if (arr[count] == null)
				return false;

			else
				return count < arr.length;
		}

		@Override
		public Word next() {
			return arr[count++];
		}
	}
}