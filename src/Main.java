import java.io.File;
import java.util.ArrayList;

public class Main 
{
	private static ArrayList<ReItem> item_list;

	public static void main(String[]Args) throws Exception
	{
		item_list = new ArrayList<>();
		File file = new File("C:/kuba/java/workspace/re_SI_1/single/p02.csv");
		ReLoader rl = new ReLoader(file);
		rl.loadItems(file, item_list);
		int max_capacity = rl.loadMaxCapacity(file);
		System.out.println("capacity : " + max_capacity);
		System.out.println();
		ReGeneticAlgorithm ga = new ReGeneticAlgorithm(100, 1000, max_capacity, 10, 0.7, 0.25, item_list);
//		ReGeneticAlgorhytm ga = new ReGeneticAlgorhytm(200, 2500, max_capacity, 2 , 0.7, 0.02, item_list);
		ga.startAlgorhitm();
	}
}
