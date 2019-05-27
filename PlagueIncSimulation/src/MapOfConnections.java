import java.util.List;
import java.util.Random;

public class MapOfConnections {
	
	private int[][] map;
	
	MapOfConnections(List<Region>list)
	{
		Random r=new Random();
		for (int i=0;i<list.size();i++)
		{
			for (int j=0;i<list.size();j++)
			{
				map[i][j]=r.nextInt(2); 
			}
		}
	}
}
