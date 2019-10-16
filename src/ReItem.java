
public class ReItem 
{
	private int score;
	private int weight;
	
	public ReItem(int score, int weight)
	{
		this.score = score;
		this.weight = weight;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getValue() {
		return weight;
	}

	public void setValue(int weight) {
		this.weight = weight;
	}
	
	public String toString()
	{
		return "score: " + this.score + " weight: " + this.weight;
	}
	

}
