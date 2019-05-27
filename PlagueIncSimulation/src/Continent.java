
public class Continent extends Area {
	private String name;

	Continent(double humidity, double temperature, double levelOfHygiene, long healthyPeople, long sickPeople,
			long deadPeople, String name) {
		super(humidity, temperature, levelOfHygiene, healthyPeople, sickPeople, deadPeople);
		this.name = name;
	}
}
