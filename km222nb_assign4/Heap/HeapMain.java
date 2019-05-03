package km222nb_assign4.Heap;

public class HeapMain {

	public static void main(String[] args) {
		BinaryIntHeap heap = new BinaryIntHeap();
		System.out.println(heap.isEmpty());
		heap.insert(24);
		heap.insert(42);
		heap.insert(5);
		heap.insert(452);
		heap.insert(15);
		heap.pullHighest();
		heap.pullHighest();

		System.out.println(heap.size());

		System.out.println(heap.toString());

	}
}
