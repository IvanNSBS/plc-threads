package safeQueue;

public class TAdd extends Thread
{
	Queue q;
	int p;
	TAdd(Queue q, int p)
	{
		this.q = q;
		this.p = p;
	}
	
	public void run() 
	{
		System.out.println("adding");
		q.Add(p);
	}
}
