package km222nb_assign3.Gods;

/**
 * Zeus please help me... haha.
 * 
 * @author Karwan
 *
 */
public class Gods {
	private String name;
	private String race;
	private String desc;

	public Gods() {

	}

	/**
	 * Constructor
	 * 
	 * @param n - name
	 * @param r - race
	 * @param d - description
	 */
	public Gods(String n, String r, String d) {
		name = n;
		race = r;
		desc = d;
	}

	/**
	 * Get the name
	 * 
	 * @return - a string representing the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name
	 * 
	 * @param a - string with a name
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * Get the race
	 * 
	 * @return - a string representing the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * Set the race
	 * 
	 * @param r - a string with the race
	 */
	public void setRace(String r) {
		race = r;
	}

	/**
	 * Get the description
	 * 
	 * @return a - a string representing the description
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Set the description
	 * 
	 * @param d - a string with the description
	 */
	public void setDesc(String d) {
		desc = d;
	}
}