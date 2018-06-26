package threads;

public class ThreadExample extends Thread
{
	int start,goal;
	
	ThreadExample(int start,int goal)
	{
		this.start = start;
		this.goal = goal;
	}
	
	public void run() 
	{
		for(int i = start; i < goal; i++)
			System.out.println(i);
	}
}
