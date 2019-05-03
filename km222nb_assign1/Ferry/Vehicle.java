package km222_nb_assign1.Ferry;

import java.util.ArrayList;

public abstract class Vehicle {

	protected int spaceRequired; // How much space is required to fit this vehicle.
	protected int vehicleFee; // The fee for this vehicle.
	protected int passengerFee; // The fee for passengers of this vehicle.
	protected int capacity; // The amount of passengers this vehicle can hold.
	protected boolean hasEmbarked = false; // Whether or not this vehicle has ever embarked on the ferry.
	protected ArrayList<Passenger> passengers; // The list of passengers on this vehicle.
	
	public boolean hasEmbarked() {
		return this.hasEmbarked;
	}

	public int getSpaceRequired() {
		return this.spaceRequired;
	}

	public ArrayList<Passenger> getPassengers() {
		return this.passengers;
	}

	public int getNumberOfPassengers() {
		return this.passengers.size();
	}

	public void addPassenger(Passenger passenger) {
		if (this.passengers.size() < this.capacity) {
			passenger.setFee(this.passengerFee);
			this.passengers.add(passenger);
		}
	}

	public void embark() {
		this.hasEmbarked = true;
	}

	public int getFee() {
		return this.vehicleFee;
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}
}