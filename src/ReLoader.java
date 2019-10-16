import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReLoader 
{
	public ReLoader(File file) throws Exception{}
	
	public void loadItems(File file, ArrayList<ReItem> item_list) throws Exception
	{
		String line;
		Scanner load = new Scanner(file); 
		int bp_size, score, weight, max_capacity;
		line = load.nextLine();
		System.out.println(line);
		String[] parts=line.split(",");
		bp_size = Integer.parseInt(parts[0]);
		max_capacity = Integer.parseInt(parts[1]);
		System.out.println("size: " + bp_size + " max: " + max_capacity);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for(int i = 0; i < bp_size; i++)
		{
			line = load.nextLine();
			String[] item_parts=line.split(",");
			score = Integer.parseInt(item_parts[0]);
			weight = Integer.parseInt(item_parts[1]);
			item_list.add(new ReItem(score, weight));
		}
		for(ReItem ri : item_list)
		{
			System.out.print(ri);
			System.out.println();
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		load.close();
	}
	
	public int loadMaxCapacity(File file) throws FileNotFoundException
	{
		String line;
		Scanner load = new Scanner(file); 
		int max_capacity;
		line = load.nextLine();
		String[] parts=line.split(",");
		max_capacity = Integer.parseInt(parts[1]);
		load.close();
		return max_capacity;
	}
}
