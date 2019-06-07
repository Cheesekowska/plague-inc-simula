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
		Symptom symptom = new Symptom();
		listOfSymptoms.add(symptom);
	}

	public void addWayOfInfection()

	{
		WayOfInfection way = new WayOfInfection();
		listOfWays.add(way);
	}
	
	public void startpointInitialize(List<Region> tableOfRegions) {
		Region r1 = tableOfRegions.get(0);
		r1.setSickPeople(100);
		r1.setLatelyInfectedPeople(100);
		r1.continent.setHealthyPeople(r1.continent.getHealthyPeople() - r1.getLatelyInfectedPeople());
		r1.continent.setSickPeople(r1.continent.getSickPeople() + r1.getLatelyInfectedPeople());
	}

	public void mutate() {
		Random r = new Random();
		int a = r.nextInt(10);
		if (a == 0) {
			this.addSymptom();
			this.addWayOfInfection();
		}
	}

	public void initializeDisease(Region region, List<Region> tableOfRegions, int map[][]) {
		if (region.isInfected) {
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
