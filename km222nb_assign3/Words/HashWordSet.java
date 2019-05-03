package km222nb_assign3.Words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {


	private int size;
	private Node[] buckets = new Node[5];


	private class Node {

		Word word;
		Node next = null;

	
		public Node(Word word) {
			this.word = word;
		}

		@Override
		public String toString() {
			return word.toString();
		}
	}


	public HashWordSet() {
		size = 0; 
	}


	@Override
	public void add(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) {
			if (node.word.equals(word)) {
				return;
			} else
				node = node.next;
		}


		node = new Node(word);
		node.next = buckets[pos];
		buckets[pos] = node;
		size++;
		if (size == buckets.length)
			rehash(); 
	}

	private void rehash() {
		Node[] temp = buckets;
		buckets = new Node[2 * temp.length];
		size = 0;
		for (Node n : temp) {
			if (n == null)
				continue;
			while (n != null) {
				add(n.word);
				n = n.next;
			}
		}

	}



	private int getBucketNumber(Word word) {
		int hash = word.hashCode();
		if (hash < 0)
			hash = -hash;
		return hash % buckets.length;
	}


	@Override
	public boolean contains(Word word) {
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) {
			if (node.word.equals(word))
				return true;
			else
				node = node.next;
		}

		return false;
	}


	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 0; i < buckets.length; i++) {
			Node node = buckets[i];
			while (node != null) {
				str.append(node.word + " ");
				node = node.next;
			}
		}
		str.append(" ]");
		return str.toString(); 
	}

	@Override
	public Iterator<Word> iterator() {
		return new HashWordSetIterator();
	}



	private class HashWordSetIterator implements Iterator<Word> {

		private int count = 0;
		private Node node = null;



		@Override
		public boolean hasNext() {
			if (node != null && node.next != null) {
				return true;
			}

			for (int i = count; i < buckets.length; i++) {
				if (buckets[i] != null) {
					return true;
				}
			}
			return false;
		}


		@Override
		public Word next() {
			if (node != null && node.next != null) {
				node = node.next;
			} else {
				do {
		
					if (count == buckets.length) {
						throw new NoSuchElementException();
					}
					node = buckets[count++];
				} while (node == null);
			}
			return node.word;

		}

	}

}