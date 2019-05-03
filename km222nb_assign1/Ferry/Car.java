package km222_nb_assign1.Ferry;

import java.util.ArrayList;

public class Car extends Vehicle {
	public Car() {
		this.spaceRequired = 5;
		this.passengerFee = 15;
		this.vehicleFee = 100;
		this.capacity = 4;
		this.passengers = new ArrayList<Passenger>();
	}
}