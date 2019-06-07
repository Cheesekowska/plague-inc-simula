
import java.io.File;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h1>PlagueInc Simulation</h1> The Simulation program implements an
 * application that makes your life easier and less complicated which means - it
 * cancels all the human beings!
 *
 * Whole thing is based on popular mobile game - PlagueInc. Names of regions are
 * taken from board game - Risk.
 *
 * <b>Note:</b> This is not a game. This is real life.
 *
 * @author Kamila Serkowska & Karol Wojtachnia
 * @version 1.0
 * @since 2019-06-06
 */

public class Simulation {

	/**
	 * This is the main method which runs whole simulation.
	 * 
	 * @param args Unused.
	 * @return Nothing.
	 * @exception IOException On input error
	 */

	public static void main(String[] args) throws IOException {

		int simulationTick = 0;

		Environment env = new Environment();
		env.createEnvironment();
		env.disease.startpointInitialize(env.tableOfRegions);

		Writer wr = new Writer();
		wr.CreateFileLista(env.tableOfRegions);
		wr.SaveTheData(env.tableOfRegions, simulationTick);

		boolean isAnyoneAlive = env.isAnyoneThere(env.tableOfRegions);

		while (isAnyoneAlive) {
			simulationTick++;
			for (Continent continent : env.tableOfContinents) {
				continent.spreadOfDiseaseOnContinent(env.tableOfContinents, env.tableOfRegions);
				env.disease.mutate();
			}

			for (Region region : env.tableOfRegions) {

				System.out.println("\n");
				System.out.println(region.getName());
				System.out.println("zdro człowiek:" + region.healthyPeople);
				System.out.println("latelyinf człowiek:" + region.latelyInfectedPeople);
				System.out.println("chory człowiek:" + region.sickPeople);

				region.spreadOfDiseaseInRegion(region, env.disease.listOfWays, env.disease.listOfSymptoms,
						simulationTick);
				if (simulationTick != 1) {
					env.disease.initializeDisease(region, env.tableOfRegions, env.map);
					env.disease.mutate();
				}
			}

			wr.SaveTheData(env.tableOfRegions, simulationTick); // zle zapisuje się 1. tick

			isAnyoneAlive = env.isAnyoneThere(env.tableOfRegions);
		}
	}
}
