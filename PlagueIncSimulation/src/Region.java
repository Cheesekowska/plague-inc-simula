
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

	public int infect() {
		// matematyczna formułka
		return latelyInfectedPeople;
	}

	public int kill() {
		// matematyczna formułka
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
