package km222_nb_assign1.Ferry;

public class Passenger {
	protected int fee = 25;
	protected boolean isEmbarked = false;

	public void embark() {
		this.isEmbarked = true;
	}

	public void disembark() {
		this.isEmbarked = false;
	}

	public boolean embarked() {
		return this.isEmbarked;
	}

	public int getFee() {
		return this.fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}
}