package km222nb_assign3.Words;

public class Word implements Comparable<Word> {
	private String word;
	private String wordLower;

	public String getWordLower() {
		return wordLower;
	}

	public Word(String str) {
		this.word = str;
		this.wordLower = str.toLowerCase();
	}


	public String toString() {
		return word;
	}

	public int hashCode() {
		return this.wordLower.hashCode();
	}

	public boolean equals(Object other) {
		if (this.hashCode() == other.hashCode()) {
			return true;
		}
		return false;
	}

	public int compareTo(Word w) {

		String mine = this.getWordLower();
		String other = w.getWordLower();

		int mySize = this.getWordLower().length();
		int otherSize = w.getWordLower().length();

		int minLength = Math.min(mySize, otherSize);

		for (int i = 0; i < minLength; i++) {
			int myChar = mine.charAt(i);
			int otherChar = other.charAt(i);

			if (myChar < otherChar)
				return -1;
			else if (myChar > otherChar)
				return 1;
		}

		if (mySize < otherSize)
			return -1;
		else if (mySize > otherSize)
			return 1;

		return 0;

	}

}