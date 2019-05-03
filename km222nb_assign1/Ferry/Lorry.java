package km222_nb_assign1.Ferry;

import java.util.ArrayList;

public class Lorry extends Vehicle {
	public Lorry() {
		this.spaceRequired = 40;
		this.passengerFee = 20;
		this.vehicleFee = 300;
		this.capacity = 2;
		this.passengers = new ArrayList<Passenger>();
	}
}