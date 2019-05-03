package km222_nb_assign1.Ferry;

public class ferryMain {

	// For all of the classes i wanted to use constructors but that failed me.
	// Used many values that changes with things such as "protected" before it.

	// Do note that the different type of vehicles have their own standards.
	// When called from the "sortThingsOut" we check for values out from those
	// different things.
	// Was tempted to use all the vehicles in one class but was unsure if that was
	// OK or not.

	// I have explained what the different type of vehicles have for standards.
	// So there won't be any comments there since it is self explanatory.

	public static void main(String[] args) {
		// Also note that adding like this with loops can cause problems....
		// But adding one by one is rather dumb so.. i will take the error if it comes
		// to it.
		Ferry ferry = new sortThingsOut();

		// Create some buses and embark them.
		for (int i = 0; i < 3; i++) {
			Vehicle bus = new Bus();
			for (int j = 0; j < bus.capacity; j++) {
				bus.addPassenger(new Passenger());
			}
			ferry.embark(bus);
		}

		// Create some lorries and embark them.
		for (int i = 0; i < 2; i++) {
			Vehicle lorry = new Lorry();
			for (int j = 0; j < lorry.capacity; j++) {
				lorry.addPassenger(new Passenger());
			}
			ferry.embark(lorry);
		}

		// Create some cars and embark them.
		for (int i = 0; i < 8; i++) {
			Vehicle car = new Car();
			for (int j = 0; j < car.capacity; j++) {
				car.addPassenger(new Passenger());
			}
			ferry.embark(car);
		}

		// Create some bikes and embark them.
		for (int i = 0; i < 20; i++) {
			Vehicle bicycle = new Bicycle();
			for (int j = 0; j < bicycle.capacity; j++) {
				bicycle.addPassenger(new Passenger());
			}
			ferry.embark(bicycle);
		}
		System.out.println(ferry.toString());
		ferry.disembark();
		System.out.println(ferry.toString());
		System.out.println("Money made so far: " + ferry.countMoney());
	}

}
