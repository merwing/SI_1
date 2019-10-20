import java.io.File;
import java.util.ArrayList;

public class Main 
{
	private static ArrayList<ReItem> item_list;
//	private static int max_capacity;

	public static void main(String[]Args) throws Exception
	{
		item_list = new ArrayList<>();
//		File file = new File("C:/Users/Administrator/Downloads/single/p08.csv");
		File file = new File("C:/kuba/java/workspace/re_SI_1/single/p04.csv");
		ReLoader rl = new ReLoader(file);
		rl.loadItems(file, item_list);
		int max_capacity = rl.loadMaxCapacity(file);
		System.out.println("capacity : " + max_capacity);
		System.out.println();
		ReGeneticAlgorhytm ga = new ReGeneticAlgorhytm(200, 70000, max_capacity, 0.5, 0.18, item_list);
//		ReGeneticAlgorhytm ga = new ReGeneticAlgorhytm(200, 60, max_capacity, 0.45, 0.15, item_list);
//		ga.GenerateFirstPopulation();
		ga.startAlgorhitm();
	}
}
