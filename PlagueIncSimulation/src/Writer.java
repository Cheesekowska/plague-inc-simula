import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {

	public static void CreateFileLista(List<Region> lista) {

		try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

			StringBuilder sb = new StringBuilder();
			sb.append("Region");
			sb.append(';');
			sb.append("Healthy people");
			sb.append(';');
			sb.append("Sick people");
			sb.append(';');
			sb.append("Dead people");
			sb.append('\n');

			for (int i = 0; i < lista.size(); i++) {
				sb.append(lista.get(i).getName());
				sb.append("\n");
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void SaveTheFreakinData(List<Region> lista) {

		try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {
			StringBuilder sb = new StringBuilder();
			sb.append("Region");
			sb.append(';');
			sb.append("Healthy people");
			sb.append(';');
			sb.append("Sick people");
			sb.append(';');
			sb.append("Dead people");
			sb.append('\n');
			for (int i = 0; i < lista.size(); i++) {
				sb.append(lista.get(i).getName() + ";");
				sb.append(Long.toString(lista.get(i).getHealthyPeople()) + ";");
				sb.append(Long.toString(lista.get(i).getSickPeople()) + ";");
				sb.append(Long.toString(lista.get(i).getDeadPeople()) + ";");
				sb.append("\n");
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
}
