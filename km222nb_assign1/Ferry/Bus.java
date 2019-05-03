package km222_nb_assign1.Ferry;

import java.util.ArrayList;

public class Bus extends Vehicle {
	public Bus() {
		this.spaceRequired = 20;
		this.passengerFee = 15;
		this.vehicleFee = 200;
		this.capacity = 20;
		this.passengers = new ArrayList<Passenger>();
	}
}