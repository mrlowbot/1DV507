package km222_nb_assign1.Ferry;

import java.util.ArrayList;

public class Bicycle extends Vehicle {
	public Bicycle() {
		this.spaceRequired = 1;
		this.passengerFee = 0;
		this.vehicleFee = 40;
		this.capacity = 1;
		this.passengers = new ArrayList<Passenger>();
	}
}