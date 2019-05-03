package km222nb_assign3;

/**
 * GCD = Greatest common denominator. If i said "14/3" i would be able to add
 * the number 3, 3 times, however we are still with a remainder of 2.
 * 
 * In that case then we would not want the user to input
 * "denominator>numerator".
 * 
 * @author Karwan
 *
 */

public class EuclideanMain {

	private static int GCD(int A, int B) {
		if (B == 0) {
			return A;
		}

		if (A < B) {
			int temp = A;
			A = B;
			B = temp;
		}

		return GCD(B, A % B);
	}

	public static void main(String[] args) {
		System.out.println("The rest is : " + GCD(18, 12));
		System.out.println("The rest is : " + GCD(42, 56));
		System.out.println("The rest is : " + GCD(9, 28));
	}

}