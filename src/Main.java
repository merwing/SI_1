import java.io.File;
import java.util.ArrayList;

public class Main 
{
	private static ArrayList<ReItem> item_list;
//	private static int max_capacity;

	public static void main(String[]Args) throws Exception
	{
		item_list = new ArrayList<>();
		File file = new File("C:/Users/Administrator/Downloads/jednoplecakowy/p08.csv");
		ReLoader rl = new ReLoader(file);
		rl.loadItems(file, item_list);
		int max_capacity = rl.loadMaxCapacity(file);
		System.out.println("capacity : " + max_capacity);
		System.out.println();
		ReGeneticAlgorhytm ga = new ReGeneticAlgorhytm(300, 50000, max_capacity, 0.6, 0.15, item_list);
//		ga.GenerateFirstPopulation();
		ga.startAlgorhitm();
	}
}
