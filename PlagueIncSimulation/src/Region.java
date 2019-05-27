
public class Region extends Area {

	private String name;
	private int number;
	private boolean isInfected;
	private int latelyInfectedPeople;
	private int latelyKilledPeople;

	public Region(double humidity, double temperature, double levelOfHygiene, int healthyPeople, int sickPeople,
			int deadPeople, String name, int number) {
		super(humidity, temperature, levelOfHygiene, healthyPeople, sickPeople, deadPeople);
		this.name = name;
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

	public int addInfected() {
		sickPeople += latelyInfectedPeople;
		return sickPeople;
	}

	public int addKilled() {
		deadPeople += latelyKilledPeople;
		return deadPeople;
	}

}
