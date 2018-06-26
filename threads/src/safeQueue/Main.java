package safeQueue;

public class Main 
{
	public static void main (String args[]) 
	{
		Queue fila = new Queue();
		
		Thread t1 = new TAdd(fila,1);
		Thread t2 = new TAdd(fila,2);
		Thread t3 = new TAdd(fila,3);
		Thread t4 = new TAdd(fila,4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		//fila.Add(5);
		try 
		{
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		}catch(InterruptedException ie) {}
		
		fila.PrintQueue();
	}
}
