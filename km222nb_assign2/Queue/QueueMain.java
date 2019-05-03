package km222nb_assign2.Queue;

/*
 * Note: I have dyslexia. So if something sounds odd then... well i have gone over all 
 * of the code many times but there is a slime chance that things don't "add up". 
 * So yeah, cannot treat dyslexia xD. 
 * 
 * @Karwan
 */
public class QueueMain {

	public static void main(String[] args) {

		LinkedQueue Q = new LinkedQueue();

		for (int i = 1; i <= 5; i++) {
			Q.enqueue(i);
		}

		System.out.println("Size: " + Q.size());
		System.out.println("String: " + Q.toString());
		System.out.println("Last object: " + Q.last());
		System.out.println("Remove and Return first element: " + Q.dequeue());
		System.out.println("Size: " + Q.size());
		System.out.println("First object: " + Q.first());
		System.out.println("Last object: " + Q.last());
		System.out.println("Remove and Return first element: " + Q.dequeue());
		System.out.println("String: " + Q.toString());
		java.util.Iterator<Object> i = Q.iterator();
		while (i.hasNext()) {

			System.out.print(i.next() + " ");

		}

	}

}
