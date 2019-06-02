
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

		// int simulationTick = 0;

		Environment env = new Environment();

		env.createEnvironment();
		Region region = env.tableOfRegions.get(0);

		region.setSickPeople(100);

		//teściki kotleciki
		// while (region.healthyPeople!=0) {
		for (int i = 0; i < 10; i++) {
			region.spreadOfDiseaseInRegion(env.tableOfRegions, env.disease.listOfWays, env.disease.listOfSymptoms, i);
			// env.disease.initializeDisease(env.tableOfRegions, env.map);
			//System.out.println("chory człowiek:" + region.sickPeople);
			//System.out.println("zdro człowiek:" + region.healthyPeople);
			// simulationTick++;
		}

		// Writer wr = new Writer();
		// wr.CreateFileLista(env.tableOfRegions);
		// wr.SaveTheFreakinData(env.tableOfRegions);

	}

}
