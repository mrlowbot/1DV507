package km222_nb_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sortThingsOut implements Ferry {
	private List<Vehicle> vehicles;
	private int cashGotten;
	private int availableVehicleSpace;
	private int availablePassengerSpace;
	private int maxVehicleSpace = 200; // Different classes have different sizes of space.
	private int maxPassengerSpace = 200; // One person = 1;

	// Here we reset everything, but not the money.
	// It is like getting to the destination and everyone leaves the ferry :).
	private void init() {
		this.availableVehicleSpace = this.maxVehicleSpace;
		this.availablePassengerSpace = this.maxPassengerSpace;
		this.vehicles = new ArrayList<Vehicle>();
	}

	// Check if there is enough passenger room.
	public int countPassengers() {
		return this.maxPassengerSpace - this.availablePassengerSpace;
	}

	// Check how much space is occupied by vehicles
	public int countVehicleSpace() {
		int count = 0;
		for (Vehicle vehicle : vehicles) {
			count += vehicle.getSpaceRequired();
		}
		return count / 5;
	}
	// Divided by 5 since we want to know the number of car spaces that have been
	// taken

	// Returns the cash.
	public int countMoney() {
		return this.cashGotten;
	}

	// No idea why we need this. Does nothing.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Iterator iterator() {
		return new VehicleIterator();
	}

	// Embark a vehicle and its passengers
	public void embark(Vehicle v) {
		if (!v.hasEmbarked() && hasSpaceFor(v)) {
			this.vehicles.add(v);
			this.cashGotten += v.getFee();
			this.availableVehicleSpace -= v.getSpaceRequired();
			v.embark();
			for (Passenger p : v.passengers) {
				embark(p);
			}
		} else {
			System.out.println(v.toString() + " doesn't fit. Skipping.");
		}
	}

	// Load a passenger on the ship.
	public void embark(Passenger p) {
		if (!p.embarked() && hasRoomFor(p)) {
			this.cashGotten += p.getFee();
			p.embark();
			this.availablePassengerSpace -= 1;
		} else {
			System.out.println(p.toString()
					+ " doesn't fit. Skipping. Their vehicle is still embarked though. Not sure about this one to be honest.");
		}
	}

	// Everyone leaves the ferry... basically.
	public void disembark() {
		for (Vehicle vehicle : this.vehicles) {
			for (Passenger p : vehicle.passengers) {
				if (p.embarked()) {
					p.disembark();
				}
			}
		}
		// Had to recall the "init" so that everything resets... except for that cash!
		init();
	}

	// Return true if there's room for the vehicle
	public boolean hasSpaceFor(Vehicle v) {
		return v.getSpaceRequired() <= this.availableVehicleSpace;
	}

	// Return true if there is space!
	public boolean hasRoomFor(Passenger p) {
		return 1 <= this.availablePassengerSpace;
	}

	public String toString() {
		// Count all the different types of vehicles, passengers and empty spaces.
		int bicycles = 0;
		int cars = 0;
		int buses = 0;
		int lorries = 0;
		int passengers = countPassengers();
		int vehicleSpace = (maxVehicleSpace / 5) - countVehicleSpace();
		for (Vehicle vehicle : this.vehicles) {
			if (vehicle.getClass() == Bicycle.class) {
				bicycles++;
			} else if (vehicle.getClass() == Car.class) {
				cars++;
			} else if (vehicle.getClass() == Bus.class) {
				buses++;
			} else if (vehicle.getClass() == Lorry.class) {
				lorries++;
			}
		}

		// Make into text.
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("The ferry currently holds:\n");
		stringBuilder.append(bicycles + " bicycles\n");
		stringBuilder.append(cars + " cars\n");
		stringBuilder.append(buses + " buses\n");
		stringBuilder.append(lorries + " lorries\n");
		stringBuilder.append(passengers + " people\n");
		stringBuilder.append(vehicleSpace + " empty spaces left for additional vehicles");

		return stringBuilder.toString();
	}

	class VehicleIterator implements Iterator<Vehicle> {
		private int count = 0;

		public Vehicle next() {
			return vehicles.get(count++);
		}

		public boolean hasNext() {
			return count < vehicles.size();
		}
	}

	public sortThingsOut() {
		this.cashGotten = 0;
		init();
	}
}
