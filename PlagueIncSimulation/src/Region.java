
public class Region extends Area {

	private int number;

	public Region(double humidity, double temperature, double levelOfHygiene, long healthyPeople, long sickPeople,
			long deadPeople, String name, boolean isInfected, int latelyInfectedPeople, int latelyKilledPeople,
			int number) {
		super(humidity, temperature, levelOfHygiene, healthyPeople, sickPeople, deadPeople, name, isInfected,
				latelyInfectedPeople, latelyKilledPeople);
		this.number = number;
	}

	public void isAnyoneSick() { // sprawdzanie czy jest już zarażenie
		if (sickPeople == 0) {
			this.isInfected = false;
		} else {
			this.isInfected = true;
		}
	}

	public int infect(List<WayOfInfection> list) {
		double factorFromWays=0;
		for (int i=0;i<list.size();i++)
		{
			factorFromWays+=this.humidity*list.get(i).tableOfFactors[0];
			factorFromWays+=this.levelOfHygiene*list.get(i).tableOfFactors[1];
			factorFromWays+=this.temperature*list.get(i).tableOfFactors[2];
		}
		return latelyInfectedPeople;
	}

	public int kill(List<Symptom>list) {
		double factorFromSymptoms=0;
		for (int i=0;i<list.size();i++)
		{
			factorFromSymptoms+=this.humidity*list.get(i).tableOfFactors[0];
			factorFromSymptoms+=this.levelOfHygiene*list.get(i).tableOfFactors[1];
			factorFromSymptoms+=this.temperature*list.get(i).tableOfFactors[2];
		}		
		return latelyKilledPeople;
	}
	public long addInfected() {
		sickPeople += latelyInfectedPeople;
		return sickPeople;
	}

	public long addKilled() {
		deadPeople += latelyKilledPeople;
		return deadPeople;
	}

}
