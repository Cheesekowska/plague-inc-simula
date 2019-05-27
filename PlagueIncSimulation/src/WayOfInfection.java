import java.util.Random;

public class WayOfInfection {
	
	
	public double[] tableOfFactors;

	WayOfInfection()
	{
		
		tableOfFactors=new double[3];
		Random r=new Random();
		this.tableOfFactors[0]=r.nextDouble()+1;
		this.tableOfFactors[1]=r.nextDouble()+1;
		this.tableOfFactors[2]=r.nextDouble()+1;
	}
}

