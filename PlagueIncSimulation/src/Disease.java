import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Disease {

	public String name;
	public ArrayList<Symptom> listOfSymptoms;
	public ArrayList<WayOfInfection> listOfWays;

	public void addSymptom() {
		Symptom symptom = new Symptom();
		listOfSymptoms.add(symptom);
	}

	public void addWayOfInfection()

	{
		WayOfInfection way = new WayOfInfection();
		listOfWays.add(way);
	}

	Disease(String name) {
		this.name = name;
		this.listOfSymptoms = new ArrayList<Symptom>();
		this.listOfWays = new ArrayList<WayOfInfection>();
	}
	
	public void initializeDisease(List<Region> tableOfRegions, int map[][]) {
		for (Region region : tableOfRegions) {
			if (region.isInfected) {
				boolean val = new Random().nextInt(5) == 0;
				if (val == true) {
					int i = region.getNumber();
					for (int j = 0; j < tableOfRegions.size(); j++) {
						if (map[i][j] == 1) {
							if (tableOfRegions.get(j).isInfected() == false) {
								tableOfRegions.get(j).setSickPeople(100);
								tableOfRegions.get(j).continent
										.setSickPeople(tableOfRegions.get(j).continent.getSickPeople() + 100);
							}
						}
					}
				}
			}
		}
	}

}
