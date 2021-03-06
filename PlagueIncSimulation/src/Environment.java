
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Environment class has methods that create basics of simulation, which are
 * objects of classes: Region, Continent and Disease.
 *
 */
public class Environment {

	List<Long> numberOfPeople = new ArrayList<>();
	List<String> namesOfRegions = new ArrayList<>();
	List<String> namesOfContinents = new ArrayList<>();
	List<Region> tableOfRegions = new ArrayList<>();
	List<Continent> tableOfContinents = new ArrayList<>();
	List<String> namesOfSingleContinents = new ArrayList<>();
	List<Long> numberOfPeopleOnContinent = new ArrayList<>();
	Disease disease;
	int map[][];

	public void createEnvironment() {
		/**
		 * This method is a manager to all the methods included in class Environment.
		 */
		uploadData();
		createContinents();
		createRegions(tableOfContinents);
		createDisease();
		map = MapOfConnections.createMapOfConnections(tableOfRegions);//

	}

	public void uploadData() {
		/**
		 * This method takes the data written in <i>.csv</i> file and puts it in several
		 * array lists for further usage.
		 */

		String line;
		String[] string;
		try (BufferedReader br = new BufferedReader(new FileReader("importedData.csv"))) {

			while ((line = br.readLine()) != null) {

				string = line.split(";");

				namesOfContinents.add(string[0]);
				namesOfRegions.add(string[1]);
				numberOfPeople.add(Long.parseLong(string[2]));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createContinents() {

		/**
		 * This method uses uploaded data to create objects of class <i>Continent</i>.
		 * Then it puts them into a <i>Continent</i> array list.
		 */

		long sumOfPeople = numberOfPeople.get(0);
		String s1 = namesOfContinents.get(0);
		namesOfSingleContinents.add(s1);
		for (int i = 0; i < namesOfContinents.size() - 1; i++) {
			s1 = namesOfContinents.get(i);
			String s2 = namesOfContinents.get(i + 1);
			if (s1.equals(s2)) {

				long addedPeople = numberOfPeople.get(i + 1);
				sumOfPeople += addedPeople;

			} else {
				namesOfSingleContinents.add(s2);
				numberOfPeopleOnContinent.add(sumOfPeople);
				sumOfPeople = numberOfPeople.get(i + 1);

			}
			if (i == namesOfContinents.size() - 2) {
				numberOfPeopleOnContinent.add(sumOfPeople);
			}

		}

		Continent continent;
		for (int i = 0; i < namesOfSingleContinents.size(); i++) {
			Random r = new Random();
			continent = new Continent(r.nextDouble() + 1, r.nextDouble() + 1, r.nextDouble() + 1,
					numberOfPeopleOnContinent.get(i), 0, 0, namesOfSingleContinents.get(i), false, 0, 0);
			tableOfContinents.add(continent);

		}

	}

	public void createRegions(List<Continent> tableOfContinents) {

		/**
		 * This method uses uploaded data to create objects of class <i>Region</i>. Then
		 * it puts them into a <i>Region</i> array list.
		 * 
		 * @param tableOfContinents This is an array list of objects from
		 *                          <i>Continent</i> class.
		 */

		Region region;
		for (int i = 0; i < namesOfRegions.size(); i++) {
			Random r = new Random();
			for (Continent continent : tableOfContinents) {
				if (continent.getName().equals(namesOfContinents.get(i))) {

					region = new Region(r.nextDouble() + 1, r.nextDouble() + 1, r.nextDouble() + 1,
							numberOfPeople.get(i), 0, 0, namesOfRegions.get(i), false, 0, 0, i, continent);
					tableOfRegions.add(region);

					break;
				}
			}

		}
	}

	public void createDisease() {
		
		/**
		 * This method creates disease (object) that will spread 
		 * in the simulation with certain parameters
		 */
		
		disease = new Disease();
		disease.addWayOfInfection();
		disease.addSymptom();
		disease.addSymptom();
		disease.addSymptom();
		disease.addWayOfInfection();
		disease.addWayOfInfection();
	}

	public boolean isAnyoneThere(List<Region> tableOfRegions) {
		
		/**
		 * Checks if there is still a positive value of
		 * healthy people in certain region
		 * 
		 * @param tableOfRegions This is an array list of objects from
		 *                          <i>Region</i> class.
		 */
		
		boolean isAnyoneAlive = true;
		boolean areThereHealthy = false;
		boolean areThereSick = false;

		for (Region region : tableOfRegions) {
			if (region.getHealthyPeople() != 0) {
				areThereHealthy = true;
			}
			if (region.getSickPeople() != 0) {
				areThereHealthy = true;
			}
		}

		if (areThereHealthy == false && areThereSick == false) {
			isAnyoneAlive = false;
		}
		return isAnyoneAlive;
	}

	public List<Region> getTableOfRegions() {
		return tableOfRegions;
	}

	public List<String> getNamesOfRegions() {
		return namesOfRegions;
	}

	public List<String> getNamesOfSingleContinents() {
		return namesOfSingleContinents;
	}

}
