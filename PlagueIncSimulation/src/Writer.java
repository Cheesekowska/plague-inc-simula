import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {

	public void CreateFileLista(List<Region> lista) {

		try (PrintWriter writer = new PrintWriter(new File("exportedData.csv"))) {

			StringBuilder sb = new StringBuilder();
			sb.append("Region;");

			for (int i = 0; i < lista.size(); i++) {
				sb.append(lista.get(i).getName());
				sb.append(";");
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public void SaveTheData(List<Region> lista, int a) throws IOException {

		try (FileWriter writer = new FileWriter("exportedData.csv", true)) {
			BufferedWriter br = new BufferedWriter(writer);
			PrintWriter pr = new PrintWriter(br);
			StringBuilder sb = new StringBuilder();
			sb.append("\n");
			sb.append(Integer.toString(a) + ".\n");
			sb.append("Healthy people;");
			for (Region region : lista) {
				sb.append(region.getHealthyPeople() + ";");
			}
			sb.append("\n");
			sb.append("Sick people;");
			for (Region region : lista) {
				sb.append(region.getSickPeople() + ";");
			}
			sb.append("\n");
			sb.append("Dead people" + ";");
			for (Region region : lista) {
				sb.append(region.getDeadPeople() + ";");
			}

			String string = sb.toString();
			pr.println(string);
			pr.close();
			br.close();
			writer.close();
			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
