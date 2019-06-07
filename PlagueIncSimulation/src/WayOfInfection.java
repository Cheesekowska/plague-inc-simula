import java.util.Random;

public class WayOfInfection {
	
	/**
	 * This class is used to change the way <i> Disease</i> behaves.
	 * It contains factors, which have an influence on how many people 
	 * are infected by the <i>Disease</i>
	 */
	
	public double[] tableOfFactors;

	WayOfInfection()
	{
	
		/**
		 * This method is a simple constructor. It gives random values
		 * to all three factors.
		 */
		
		tableOfFactors=new double[3];
		Random r=new Random();
		this.tableOfFactors[0]=r.nextDouble()+1;
		this.tableOfFactors[1]=r.nextDouble()+1;
		this.tableOfFactors[2]=r.nextDouble()+1;
	}
}

