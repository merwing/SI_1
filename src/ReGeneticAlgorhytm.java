import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ReGeneticAlgorhytm 
{
	private int iterations, max_capacity, pop_size;
	private double px, pm;
	private ArrayList<ReItem> item_list;
	private ArrayList<ReSolution> old_pop, new_pop;
	private Random random = new Random();
	
	public ReGeneticAlgorhytm(int iterations, int pop_size, int max_capacity, double px, double pm, ArrayList<ReItem> item_list)
	{
		this.iterations = iterations;
		this.max_capacity = max_capacity;
		this.pop_size = pop_size;
		this.px = px;
		this.pm = pm;
		this.item_list = item_list;
	}
	
	public void GenerateFirstPopulation()
	{
		old_pop = new ArrayList<>();
		ReSolution s;
		for(int i = 0; i < pop_size; i++)
		{
			s = new ReSolution(this.max_capacity, this.item_list.size());
			calculateWeight(s);
			old_pop.add(s);
		}
//		for(ReSolution x : old_pop)
//		{
//			x.DisplayBackpack();
//		}
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		for(ReSolution xi : old_pop)
//		{
//			System.out.print("score : "+xi.getBp_score()+ " weight: " + xi.getBp_weight());
//			System.out.println();
//		}
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//gytgygyg
	}
	
	public void calculateScore(ReSolution rs)
	{
		int main_score = 0;
		for(int i = 0; i < rs.getBackpack().length; i++)
		{
			if(rs.getBackpack()[i] == 1)
			{
				main_score += item_list.get(i).getScore();
			}
		}
		rs.setBp_score(main_score);
	}
	
	public void calculateWeight(ReSolution rs)
	{
		int main_weight = 0;
		for(int i = 0; i < rs.getBackpack().length; i++)
		{
			if(rs.getBackpack()[i] == 1)
			{
				main_weight += item_list.get(i).getValue();
			}
		}
		if(main_weight <= this.max_capacity)
		{
			rs.setBp_weight(main_weight);
			calculateScore(rs);
		}
		else
		{
			rs.setBp_weight(main_weight);
			rs.setBp_score(0);
		}
		
	}
	
	public ReSolution Tournament()
	{
		int index_1 = random.nextInt(old_pop.size());
		int index_2 = random.nextInt(old_pop.size());
//		int index_3 = random.nextInt(old_pop.size());
		
		ReSolution rs1 = old_pop.get(index_1);
		ReSolution rs2 = old_pop.get(index_2);
		
		return (rs1.getBp_score() >= rs2.getBp_score() ? rs1 : rs2);}
//		if(rs1.getBp_score() >= rs2.getBp_score())
//		{
//			return rs1;
//		}
//		else
//		{
//			return rs2;
//		}
//	}
	
	public int bestScore(ArrayList<ReSolution> pop) 
	{
		int best_score = 0;
		for(ReSolution rs : pop)
		{
			if(rs.getBp_score() >= best_score)
			{
				best_score = rs.getBp_score();
			}
		}
		return best_score;
	}
	
	public int worstScore(ArrayList<ReSolution> pop)
	{
		int worst_score = 0;
		for(ReSolution rs : pop)
		{
			if(rs.getBp_score() <= worst_score)
			{
				worst_score = rs.getBp_score();
			}
		}
		return worst_score;
	}
	
	public int avg_score(ArrayList<ReSolution> pop)
	{
		int sum = 0;
		for(ReSolution rs : pop)
		{
			sum += rs.getBp_score();
		}
		return (sum/pop.size());
	}
	
	public void startMutation(ArrayList<ReSolution> pop)
	{
		for(ReSolution rs : pop)
		{
			rs.mutate2(this.pm);
			calculateWeight(rs);
		}
	}
	
	public void startAlgorhitm() throws FileNotFoundException
	{
		int best_score;
		int worst_score;
		int avg_score;
		File fil = new File("C:/kuba/java/workspace/re_SI_1/single/sp8-200-70-1.csv");
		PrintWriter pw = new PrintWriter(fil);
		GenerateFirstPopulation();
		new_pop = new ArrayList<>();
		for(int i = 0; i < this.iterations; i++)
		{
			int index = i+1;
			for(int j = 0; j < this.old_pop.size()/2; j++)
			{
				ReSolution p1 = Tournament();
				ReSolution p2 = Tournament();
				
				int r_cross_prob = (random.nextInt(101)/100); // 0->100
				if(r_cross_prob <= this.px)
				{
					p1.cross(p2);
					calculateWeight(p1);
					calculateWeight(p2);
					new_pop.add(p1);
					new_pop.add(p2);
				}
				else
				{
					new_pop.add(p1);
					new_pop.add(p2);
					calculateWeight(p1);
					calculateWeight(p2);
				}
			}
			best_score = bestScore(old_pop);
			worst_score = worstScore(old_pop);
			avg_score = avg_score(old_pop);
			
			System.out.println("Population: " + index + " best score: " +best_score + " worst score: " + worst_score + " avg score: " + avg_score);
			startMutation(new_pop);
			old_pop.clear();
			old_pop.addAll(new_pop);
			StringBuilder sb = new StringBuilder();
			sb.append(index);
			sb.append(", ");
			sb.append(best_score);
			sb.append(", ");
			sb.append(worst_score);
			sb.append(", ");
			sb.append(avg_score);
			sb.append('\n');
			pw.write(sb.toString());
			new_pop.clear();
		}
		pw.close();
		
		
	}

}
