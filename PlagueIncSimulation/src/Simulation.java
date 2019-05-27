
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {

	public static void main(String[] args) {

		List<Integer> numberOfPeople = new ArrayList<>();
		List<String> namesOfRegions = new ArrayList<>();
		List<String> namesOfContinents = new ArrayList<>();
		List<Region> tableOfRegions = new ArrayList<>();
		List<Region> tableOfContinents = new ArrayList<>();
		List<String> namesOfSingleContinents = new ArrayList<>();
		List<Long> numberOfPeopleInContinent = new ArrayList<>();

		String line;
		String[] string;
		try (BufferedReader br = new BufferedReader(new FileReader("importedData.csv"))) {

			while ((line = br.readLine()) != null) {

				string = line.split(";");
				namesOfRegions.add(string[1]);
				namesOfContinents.add(string[0]);
				numberOfPeople.add(Integer.parseInt(string[2]));

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Continent continent;
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
				numberOfPeopleInContinent.add(sumOfPeople);
				sumOfPeople = numberOfPeople.get(i + 1);

			}
			if (i==namesOfContinents.size() - 2) {
				numberOfPeopleInContinent.add(sumOfPeople);
			}

		}

		System.out.println(numberOfPeopleInContinent);
		System.out.println(namesOfSingleContinents);

	}

}
