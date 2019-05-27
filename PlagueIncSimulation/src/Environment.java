
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Environment {

	static List<Long> numberOfPeople = new ArrayList<>();
	static List<String> namesOfRegions = new ArrayList<>();
	static List<String> namesOfContinents = new ArrayList<>();
	static List<Region> tableOfRegions = new ArrayList<>();
	static List<Continent> tableOfContinents = new ArrayList<>();
	static List<String> namesOfSingleContinents = new ArrayList<>();
	static List<Long> numberOfPeopleOnContinent = new ArrayList<>();

	public void createEnvironment() {

		uploadData();
		createRegions();

	}

	public void uploadData() {

		String line;
		String[] string;
		try (BufferedReader br = new BufferedReader(new FileReader("importedData.csv"))) {

			while ((line = br.readLine()) != null) {

				string = line.split(";");
				namesOfRegions.add(string[0]);
				namesOfContinents.add(string[1]);
				numberOfPeople.add(Long.parseLong(string[2]));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createRegions() {
		Region region;
		for (int i = 0; i < namesOfRegions.size(); i++) {
			Random r = new Random();
			region = new Region(r.nextDouble() + 1, r.nextDouble() + 1, r.nextDouble() + 1, numberOfPeople.get(i), 0, 0,
					namesOfRegions.get(i), false, 0, 0, i);
			tableOfRegions.add(region);
		}
	}

	public void createContinents() {

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

}
