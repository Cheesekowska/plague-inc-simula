import java.util.Random;

public class Symptom {
	
	/**
	 * This class is used to change the way <i> Disease</i> kills people.
	 * It contains factors, which have an influence on how many people 
	 * are killed by it.
	 */

	public double[] tableOfFactors;

	Symptom() {
		
		/**
		 * This method is a simple constructor. It gives random values
		 * to all three factors.
		 */

		this.tableOfFactors = new double[3];
		Random r = new Random();
		this.tableOfFactors[0] = r.nextDouble() + 1;
		this.tableOfFactors[1] = r.nextDouble() + 1;
		this.tableOfFactors[2] = r.nextDouble() + 1;
	}
}
