package km222_nb_assign1.Collection;

public class ArrayIntList extends AbstractIntCollection implements IntList {
	
	
	
	public void add(int n) {
		if (this.values.length == this.size) {
			this.resize();
		}
		this.values[this.size++] = n;
	}

	public void addAt(int n, int index) {
		if (this.values.length == this.size) {
			this.resize();
		}

		for (int i = this.size; i >= index; i--) {
			this.values[i] = this.values[i - 1];
		}
		this.values[index] = n;
		this.size++;
	}

	public void remove(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}
		for (int i = index; i < size; i++) {
			this.values[i] = this.values[i + 1];
		}
		this.size--;
	}

	public int get(int index) {
		return this.values[index];
	}

	public int indexOf(int n) {
		for (int i = 0; i < this.size; i++) {
			if (this.values[i] == n) {
				return i;
			}
		}
		return -1;
	}
}