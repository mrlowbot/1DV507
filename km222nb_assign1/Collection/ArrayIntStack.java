package km222_nb_assign1.Collection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	// The only thing to really note here is how "size" is being use.
	// If size don't change then the index of that array don't change.

	public void push(int n)
	// Resize if they are equal.
	{
		if (this.values.length == this.size) {
			this.resize();
		}
		this.values[size++] = n;
	}

	public int pop() {
		// If the size is greater then 0 then we return the values index with a size
		// lower.
		if (size > 0) {
			return this.values[--size];
		}
		throw new IndexOutOfBoundsException();
	}

	public int peek() {
		if (size > 0) {
			return this.values[size - 1];
		}
		throw new IndexOutOfBoundsException();
	}
}