

import java.util.ArrayList;
import java.util.Random;

public class ReSolution 
{
	
	private int[] backpack;
	private int bp_weight;
	private int bp_score;
	private int max_capacity;
	private int bp_size;
	private ArrayList<ReItem> item_list;
	public static Random random = new Random();

	public ReSolution(int max_capacity, int bp_size) 
	{
		this.max_capacity = max_capacity;
		this.bp_size = bp_size;
		this.backpack = new int[this.bp_size];
		Fill_backpack();
		setBp_score(0);
		setBp_weight(0);
	}

	public void Fill_backpack()
	{
		int gene = -1;
//		int prob = -1;
		for(int i=0; i<backpack.length; i++)
		{
//			prob = random.nextInt(101);
//			if(prob <= 65)
//			{
//				backpack[i] = 0;
//			}
//			else
//			{
//				backpack[i] = 1;
//			}
			gene=random.nextInt(2);
			backpack[i]=gene;
		}	
	}
	
	public void DisplayBackpack()
	{
		for(int i = 0; i < backpack.length; i++)
		{
			System.out.print(backpack[i] + ",");
		}
		System.out.println("");
	}
	
	public void mutate2(double pm)
	{
		double prob_mut = (random.nextInt(101)/100); //0->100/100
		if(prob_mut <= pm)
		{
			for(int i = 0; i < backpack.length; i++) 
			{
				if(backpack[i] == 1)
				{
					backpack[i] = 0;
				}
				else
				{
					backpack[i] = 1;
				}
			}
		}
	}
	
	public void mutate(double pm)
	{
		double prob_mut;
		
		for(int i = 0; i < backpack.length; i++)
		{
			prob_mut = (random.nextInt(101)/100); //0->100/100
			if(prob_mut <= pm)
			{
				if(backpack[i] == 1)
				{
					backpack[i] = 0;
				}
				else
				{
					backpack[i] = 1;
				}
			}
		}
	}
	
	public void cross(ReSolution s)
	{
		ReSolution temp1 = this;
		ReSolution temp2 = s;
		int index = random.nextInt(backpack.length); //0->4
		if(index != backpack.length-1)
		{
			for(int i = index; i < backpack.length; i++)
			{
				temp1.backpack[i] = s.backpack[i];
			}
			for(int j = 0; j < index; j++)
			{
				temp2.backpack[j] = this.backpack[j];
			}
		}
		this.setBackpack(temp1.backpack);
		s.setBackpack(temp2.backpack);
		
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public int[] getBackpack() {
		return backpack;
	}

	public void setBackpack(int[] backpack) {
		this.backpack = backpack;
	}

	public int getBp_weight() {
		return bp_weight;
	}

	public void setBp_weight(int bp_weight) {
		this.bp_weight = bp_weight;
	}

	public int getBp_score() {
		return bp_score;
	}

	public void setBp_score(int bp_score) {
		this.bp_score = bp_score;
	}

	public int getMaxCapacity() {
		return max_capacity;
	}

	public void setMaxCapacity(int max_capacity) {
		this.max_capacity = max_capacity;
	}

	public int getBackpack_size() {
		return bp_size;
	}

	public void setBackpack_size(int bp_size) {
		this.bp_size = bp_size;
	}

	public ArrayList<ReItem> getItem_list() {
		return item_list;
	}

	public void setItem_list(ArrayList<ReItem> item_list) {
		this.item_list = item_list;
	}
	
	

}
