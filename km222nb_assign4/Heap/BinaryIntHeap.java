package km222nb_assign4.Heap;

import java.util.ArrayList;

public class BinaryIntHeap {
	private ArrayList<Integer> Elements = new ArrayList<>();

	public BinaryIntHeap() {
		Elements.add(null);
	}

	public void insert(int n) {
		Elements.add(null);
		int index = Elements.size() - 1;

		while (index > 1 && getParent(index) < n) {
			Elements.set(index, getParent(index));
			index = getParentIndex(index);
		}
		Elements.set(index, n);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < Elements.size(); i++) {
			builder.append(Elements.get(i) + " ");
		}
		return builder.toString();
	}

	public int pullHighest() {
		int highest = Elements.get(1);
		int lastIndex = Elements.size() - 1;
		int last = Elements.remove(lastIndex);

		if (lastIndex > 1) {
			Elements.set(1, last);
			percolateDown();
		}
		return highest;
	}

	public int size() {
		return Elements.size() - 1;
	}

	public boolean isEmpty() {
		if (Elements.size() == 1) {
			return true;
		}
		return false;
	}

	private void percolateDown() {
		int root = Elements.get(1);
		int lastIndex = Elements.size() - 1;
		int index = 1;
		boolean getBigger = true;

		while (getBigger) {
			int childIndex = getLeftChildIndex(index);
			if (childIndex <= lastIndex) {
				int child = getLeftChild(index);

				if (getRightChildIndex(index) <= lastIndex && getRightChild(index) > child) {
					childIndex = getRightChildIndex(index);
					child = getRightChild(index);
				}

				if (child > root) {
					Elements.set(index, child);
					index = childIndex;
				} else {
					getBigger = false;
				}
			} else {
				getBigger = false;
			}
		}
		Elements.set(index, root);
	}

	private int getParent(int index) {
		return Elements.get(index / 2);
	}

	private int getParentIndex(int index) {
		return index / 2;
	}

	private int getLeftChild(int index) {
		return Elements.get(2 * index);
	}

	private int getRightChild(int index) {
		return Elements.get(2 * index + 1);
	}

	private int getLeftChildIndex(int index) {
		return 2 * index;
	}

	private int getRightChildIndex(int index) {
		return 2 * index + 1;
	}

}