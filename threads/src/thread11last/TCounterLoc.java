package thread11last;

public class TCounterLoc extends Thread
{
	int goal;
	int var = 0;
	
	TCounterLoc(int goal)
	{
		this.goal = goal;
	}
	
	public void run() 
	{
		for(int i = 0; i < goal; i++) 
		{
			var++;
			System.out.println(i);
		}
	}
}
