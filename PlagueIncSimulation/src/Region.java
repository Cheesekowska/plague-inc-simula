import java.util.List;

public class Region extends Area {

	private int number;
	Continent continent;

	public Region(double humidity, double temperature, double levelOfHygiene, long healthyPeople, long sickPeople,
			long deadPeople, String name, boolean isInfected, int latelyInfectedPeople, int latelyKilledPeople,
			int number, Continent continent) {
		super(humidity, temperature, levelOfHygiene, healthyPeople, sickPeople, deadPeople, name, isInfected,
				latelyInfectedPeople, latelyKilledPeople);
		this.number = number;
		this.continent = continent;
	}

	public void spreadOfDiseaseInRegion(Region region, List<WayOfInfection> listOfWays, List<Symptom> listOfSymptoms,
			int simulationTick) { // sprawdzanie czy jest już zarażenie

		if (region.getSickPeople() != 0) {
			region.setInfected(true);
			region.infect(listOfWays, region, simulationTick);

			if (region.getSickPeople() >= 0.4 * (region.getHealthyPeople() + region.getSickPeople())) {
				region.kill(listOfSymptoms, region, simulationTick);
			}
		}
	}

	public void infect(List<WayOfInfection> listOfWays, Region region, int simulationTick) { // pamiętać o dodaniu do
		// kontynentu
		double factorFromWays = 0;
		for (int i = 0; i < listOfWays.size(); i++) {
			factorFromWays += this.humidity * listOfWays.get(i).tableOfFactors[0];
			factorFromWays += this.levelOfHygiene * listOfWays.get(i).tableOfFactors[1];
			factorFromWays += this.temperature * listOfWays.get(i).tableOfFactors[2];
		}
		region.setLatelyInfectedPeople((long) (factorFromWays * Math.exp(simulationTick))); // PODZIELIĆ FAKTOR NA 10?
		if (region.getHealthyPeople() - region.getLatelyInfectedPeople() >= 0) {
			region.setHealthyPeople(region.getHealthyPeople() - region.getLatelyInfectedPeople());
			region.continent.setHealthyPeople(region.continent.getHealthyPeople() - region.getLatelyInfectedPeople());// czy
			region.setSickPeople(region.getSickPeople() + region.getLatelyInfectedPeople());
			region.continent.setSickPeople(region.continent.getSickPeople() + region.getLatelyInfectedPeople());
		} else {
			region.setLatelyInfectedPeople(region.getHealthyPeople());
			region.setHealthyPeople(0);
			region.continent.setHealthyPeople(region.continent.getHealthyPeople() - region.getLatelyInfectedPeople());
			region.setSickPeople(region.getSickPeople() + region.getLatelyInfectedPeople());
			region.continent.setSickPeople(region.continent.getSickPeople() + region.getLatelyInfectedPeople());

		}

	}

	public void kill(List<Symptom> listOfSymptoms, Region region, int simulationTick) {
		double factorFromSymptoms = 0;
		for (int i = 0; i < listOfSymptoms.size(); i++) {
			factorFromSymptoms += this.humidity * listOfSymptoms.get(i).tableOfFactors[0];
			factorFromSymptoms += this.levelOfHygiene * listOfSymptoms.get(i).tableOfFactors[1];
			factorFromSymptoms += this.temperature * listOfSymptoms.get(i).tableOfFactors[2];
		}
		region.setLatelyKilledPeople((long) (factorFromSymptoms * Math.exp(simulationTick - 10)));
		if (region.getSickPeople() - region.getLatelyKilledPeople() >= 0) {
			region.setSickPeople(region.getSickPeople() - region.getLatelyKilledPeople());
			region.continent.setSickPeople(region.continent.getSickPeople() - region.getLatelyKilledPeople());
			region.setDeadPeople(region.getDeadPeople() + region.getLatelyKilledPeople());
			region.continent.setDeadPeople(region.continent.getDeadPeople() + region.getLatelyKilledPeople());
		}

		else {
			region.setLatelyKilledPeople(region.getSickPeople());
			region.setSickPeople(0);
			region.continent.setSickPeople(region.continent.getSickPeople() - region.getLatelyKilledPeople());
			region.setDeadPeople(region.getDeadPeople() + region.getLatelyKilledPeople());
			region.continent.setDeadPeople(region.continent.getDeadPeople() + region.getLatelyKilledPeople());

		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

}
