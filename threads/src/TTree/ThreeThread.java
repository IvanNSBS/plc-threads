package TTree;

import java.util.Random;

public class ThreeThread extends Thread
{
	Tree t;
	ThreeThread(Tree t)
	{
		this.t = t;
	}
	
	public void run() 
	{
		Random random = new Random();
		int key = random.nextInt();
		
		for(int i = 0; i < 2000; i++)
			t.Add(key);
	}
}
