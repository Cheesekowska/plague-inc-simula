import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Disease {

	public String name;
	public ArrayList<Symptom> listOfSymptoms;
	public ArrayList<WayOfInfection> listOfWays;
	
	public void addSymptom ()
	{
		Symptom symptom=new Symptom();
		listOfSymptoms.add(symptom);
	}
	public void addWayOfInfection ()
	
	{
		WayOfInfection way=new WayOfInfection();
		listOfWays.add(way);
	}


	Disease(String name) {
		this.name = name;
		this.listOfSymptoms=new ArrayList<Symptom>();
		this.listOfWays=new ArrayList<WayOfInfection>();
	}
	
		
	}


