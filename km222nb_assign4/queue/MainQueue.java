package km222nb_assign4.queue;

import java.util.Iterator;

/*
 * I had some help with this. Also had so problems with the LinkedQueue.
 * @Karwan
 */

public class MainQueue {
	public static void main(String[] args) {

		System.out.println("Linked Queue:");
		Queue<Integer> Q = new LinkedQueue<Integer>();
		System.out.println("Empty: " + Q.isEmpty());
		Q.enqueue(3);
		Q.enqueue(4);
		Q.enqueue(8);
		Q.enqueue(7);
		Q.dequeue();
		System.out.println("First: " + Q.first());
		System.out.println("Last: " + Q.last());

		Iterator<Integer> iterator = Q.iterator();

		System.out.println("Iterator: ");
		while (iterator.hasNext()) {
			Object val = iterator.next();
			System.out.println(val);
		}

		System.out.println(Q.toString());

		Queue<String> Q1 = new LinkedQueue<String>();
		System.out.println("Empty: " + Q1.isEmpty());
		Q1.enqueue("This");
		Q1.enqueue("is");
		Q1.enqueue("a");
		Q1.enqueue("test");
		Q1.dequeue();
		System.out.println("First: " + Q1.first());
		System.out.println("Last: " + Q1.last());

		Iterator<String> iterator1 = Q1.iterator();

		System.out.println("Iterator: ");
		while (iterator1.hasNext()) {
			Object val = iterator1.next();
			System.out.println(val);
		}

		System.out.println(Q1.toString());
	}
}