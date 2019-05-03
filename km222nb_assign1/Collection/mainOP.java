package km222_nb_assign1.Collection;

import java.util.Random;

public class mainOP {

	public static void main(String[] args) {

		// Normally i would not call classes via the interface. I would call the class
		// directly! 
		// Asked some people online and they said that it woulnd't matter which way i
		// did it.
		// But i still think that this might be a wrong way of calling everything.
		Random r = new Random();

		IntList intList = new ArrayIntList();
		// From the interface to the ArrayIntList with the interface.
		// Just added a bunch of numbers.
		intList.add(4);
		intList.add(5);
		intList.add(7);
		intList.add(12);
		intList.add(14);
		intList.add(17);
		// Theses are self explanatory...
		System.out.println(intList.toString());
		intList.addAt(22, 4);
		System.out.println(intList.toString());
		intList.remove(3);
		System.out.println(intList.toString());
		System.out.println("Value at index 1: " + intList.get(1));
		System.out.println("Index of 14: " + intList.indexOf(14));

		System.out.println();
		System.out.println();

		IntStack intStack = new ArrayIntStack(); // From the interface to the ArrayIntStack with the interface.
		// Here i made a simple loop that will add a number between 0 and 101 6 times.
		// Looks better than "intStack.push(Whatever number) multiple of times.
		for (int i = 0; i < 6; i++) {
			intStack.push(r.nextInt(100));
		}
		// But to be on the safe side i also just made one with 420 to show that
		// everything goes in right. Had to put some 420 memes in there... heh.
		intStack.push(420);

		System.out.println(intStack.toString());
		System.out.println("Popping: " + intStack.pop());
		System.out.println(intStack.toString());
		System.out.println("Peeking: " + intStack.peek());
		System.out.println(intStack.toString());
	}

}
