public class Area {


	double humidity; // poziom wilgotności
	double temperature; // współczynnik temperatury
	double levelOfHygiene; // poziom higieny
	long healthyPeople; // ilość zdrowych osób
	long sickPeople; // ilość chorych osób
	long deadPeople; // ilość martwych osób
	String name;
	boolean isInfected;
	long latelyInfectedPeople;
	long latelyKilledPeople;
	
	public Area(double humidity, double temperature, double levelOfHygiene, long healthyPeople, long sickPeople,
			long deadPeople, String name, boolean isInfected, int latelyInfectedPeople, int latelyKilledPeople) {
		this.name = name;
		this.humidity = humidity;
		this.temperature = temperature;
		this.levelOfHygiene = levelOfHygiene;
		this.healthyPeople = healthyPeople;
		this.sickPeople = sickPeople;
		this.deadPeople = deadPeople;
		this.isInfected = isInfected;
		this.latelyInfectedPeople = latelyInfectedPeople;
		this.latelyKilledPeople = latelyKilledPeople;
	}


	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getLevelOfHygiene() {
		return levelOfHygiene;
	}

	public void setLevelOfHygiene(double levelOfHygiene) {
		this.levelOfHygiene = levelOfHygiene;
	}

	public long getHealthyPeople() {
		return healthyPeople;
	}

	public void setHealthyPeople(long healthyPeople) {
		this.healthyPeople = healthyPeople;
	}

	public long getSickPeople() {
		return sickPeople;
	}

	public void setSickPeople(long sickPeople) {
		this.sickPeople = sickPeople;
	}

	public long getDeadPeople() {
		return deadPeople;
	}

	public void setDeadPeople(long deadPeople) {
		this.deadPeople = deadPeople;
	}

	public boolean isInfected() {
		return isInfected;
	}

	public void setInfected(boolean isInfected) {
		this.isInfected = isInfected;
	}

	public long getLatelyInfectedPeople() {
		return latelyInfectedPeople;
	}

	public void setLatelyInfectedPeople(long latelyInfectedPeople) {
		this.latelyInfectedPeople = latelyInfectedPeople;
	}

	public long getLatelyKilledPeople() {
		return latelyKilledPeople;
	}

	public void setLatelyKilledPeople(long latelyKilledPeople) {
		this.latelyKilledPeople = latelyKilledPeople;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
