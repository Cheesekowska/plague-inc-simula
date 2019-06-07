import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Disease {

	public String name;
	public ArrayList<Symptom> listOfSymptoms;
	public ArrayList<WayOfInfection> listOfWays;
	
	Disease(String name) {
		this.name = name;
		this.listOfSymptoms = new ArrayList<Symptom>();
		this.listOfWays = new ArrayList<WayOfInfection>();
	}

	public void addSymptom() {
		
		/**
		 * This method adds new object of class <i>Symptom</i>
		 * to an array list, which is then used by objects of class 
		 * <i>Disease</i>.
		 */
		
		Symptom symptom = new Symptom();
		listOfSymptoms.add(symptom);
	}

	public void addWayOfInfection()
	{

		/**
		 * This method adds new object of class <i>WayOfInfection</i>
		 * to an array list of <i>WayOfInfection</i> objects,
		 *  which is then used by <i>Disease</i> objects.
		 */
		
		WayOfInfection way = new WayOfInfection();
		listOfWays.add(way);
	}
	
	public void startpointInitialize(List<Region> tableOfRegions) {
		
		/**
		 * This method is used to initialize the disease in the first region.
		 * @param tableOfRegions contains  a <i>List</i> object with alle the 
		 * <i> Regions </i> in the simulation.
		 */
		
		Region r1 = tableOfRegions.get(0);
		r1.setSickPeople(100);
		r1.setLatelyInfectedPeople(100);
		r1.continent.setHealthyPeople(r1.continent.getHealthyPeople() - r1.getLatelyInfectedPeople());
		r1.continent.setSickPeople(r1.continent.getSickPeople() + r1.getLatelyInfectedPeople());
	}

	public void mutate() {
		
		/**
		 * This method randomly (with ratio of 10%) adds new <i>Symptom</i> and <i>WayOfInfection</i> objects
		 * to the <i>Disease</i> object.
		 * 
		 */
		
		Random r = new Random();
		int a = r.nextInt(10);
		if (a == 0) {
			this.addSymptom();
			this.addWayOfInfection();
		}
	}

	public void initializeDisease(Region region, List<Region> tableOfRegions, int map[][]) {
		if (region.isInfected) {
			
			/** 
		 * This method initializes the <i>Disease</i> in a <i>region</i>. It means setting the 
		 * first amount of <b> sickPeople </b>, and setting the <b>isInfected</b> field to 
		 * TRUE value.
		 * @param region is object of class <i> Region </i>, which gives the information,
		 * which region to initialize.
		 * @param tableOfRegions is an array list of all regions in the simulation
		 * @param map is an array variable, which contains iformation about connections
		 * between regions 
		 */
			
			int i = region.getNumber();
			for (int j = 0; j < tableOfRegions.size(); j++) {
				if (map[i][j] == 1) {
					if (tableOfRegions.get(j).isInfected() == false) {
						boolean val = new Random().nextInt(4) == 0;
						if (val == true) {
							tableOfRegions.get(j).setInfected(true);
							tableOfRegions.get(j).setSickPeople(10);// COŚ Z TYM ZROBIĆ
							tableOfRegions.get(j).setLatelyInfectedPeople(tableOfRegions.get(j).getSickPeople());//
							tableOfRegions.get(j).setHealthyPeople(tableOfRegions.get(j).getHealthyPeople()
									- tableOfRegions.get(j).getLatelyInfectedPeople());
							tableOfRegions.get(j).continent
									.setSickPeople(tableOfRegions.get(j).continent.getSickPeople()
											+ tableOfRegions.get(j).getLatelyInfectedPeople());

						}
					}

				}

			}
		}
	}
}
