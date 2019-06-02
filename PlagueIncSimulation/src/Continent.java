import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Continent extends Area {

	Continent(double humidity, double temperature, double levelOfHygiene, long healthyPeople, long sickPeople,
			long deadPeople, String name, boolean isInfected, int latelyInfectedPeople, int latelyKilledPeople) {
	
		super(humidity, temperature,  levelOfHygiene,  healthyPeople,  sickPeople,
				 deadPeople,  name,  isInfected,  latelyInfectedPeople,  latelyKilledPeople); // czy parametry dodać?

	}


	public void spreadOfDiseaseOnContinent(List<Continent> tableOfContinents, List<Region> tableOfRegions) {
		for (Continent continent : tableOfContinents) {
			if (continent.isHalfOfPopulationSick(continent)) {
				continent.infect(tableOfRegions, continent);
				continent.kill(tableOfRegions, continent);
			}
		}
	}

	public boolean isHalfOfPopulationSick(Continent continent) { // sprawdzanie czy jest już zarażenie

		long continentPopulation = continent.getDeadPeople() + continent.getHealthyPeople() + continent.getSickPeople();
		if (continent.getSickPeople() >= 0.5 * continentPopulation) {
			return true;
		}

//		for (int continentId = 0; continentId < tableOfContinents.size(); continentId++) {
//			long continentPopulation = tableOfContinents.get(continentId).getDeadPeople()
//					+ tableOfContinents.get(continentId).getHealthyPeople()
//					+ tableOfContinents.get(continentId).getSickPeople();
//			if (tableOfContinents.get(continentId).getSickPeople() >= (0.5 * continentPopulation)) {
//				return continentId;
//			}
//		}
		return false;
	}

	public List<Region> helpfulList(List<Region> tableOfRegions) {
		List<Region> helpfulList = new ArrayList<>();
		for (Region region : tableOfRegions) {
			if (region.continent.name.equals(name)) {  //wait what, może być zle ale bedzie dobrze
				helpfulList.add(region);
			}
		}
		return helpfulList;

	}

	public void infect(List<Region> tableOfRegions, Continent continent) {

		List<Region> helpfulList = continent.helpfulList(tableOfRegions);
		Random r = new Random();
		int numberOfChosenRegion = r.nextInt(helpfulList.size());
		Region chosenRegion = helpfulList.get(numberOfChosenRegion);
		chosenRegion.setSickPeople(chosenRegion.getSickPeople() + chosenRegion.getHealthyPeople());
		chosenRegion.setHealthyPeople(0);
	}

	public void kill(List<Region> tableOfRegions, Continent continent) {

		List<Region> helpfulList = continent.helpfulList(tableOfRegions);

		for (Region region : helpfulList) {
			if (region.getHealthyPeople() == 0) {
				boolean val = new Random().nextInt(10) == 0;
				if (val == true) {
					region.setDeadPeople(region.getDeadPeople() + region.getHealthyPeople() + region.getSickPeople());
					region.setSickPeople(0);
					region.setHealthyPeople(0);
				}
			}
		}

	}

}
