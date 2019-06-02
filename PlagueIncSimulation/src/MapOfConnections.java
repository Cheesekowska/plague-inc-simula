import java.util.List;
import java.util.Random;

public class MapOfConnections {

	public static int[][] createMapOfConnections(List<Region> tableOfRegions) {
		Random r = new Random();
		int[][] map = new int[tableOfRegions.size()][tableOfRegions.size()];

		for (int i = 0; i < tableOfRegions.size(); i++) {
			for (int j = 0; j < tableOfRegions.size(); j++) {
				map[i][j] = r.nextInt(2);
				// System.out.println(map[i][j]);
			}
		}
		return map;
	}

}