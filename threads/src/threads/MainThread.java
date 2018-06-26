package threads;
import java.util.LinkedList;

public class MainThread
{
	
	public static void GetPrimeNumbers(int threadAmount, int goal) 
	{
		LinkedList<Integer> primeNumbers = new LinkedList();
		Thread threadList[] = new Thread[threadAmount];
		int startpos = 1;
		for(int i = 1; i <= threadAmount; i++) 
		{
			Thread t = new IsPrimeThread(startpos, 100*i, primeNumbers);
			threadList[i-1] = t;
			System.out.println(startpos + " " + i*100);
			startpos = (goal/threadAmount)*i;
		}
		
		for(int i = 0; i < threadAmount; i++) 
		{
			threadList[i].start();
		}
		
		for(int i = 0; i < threadAmount; i++) 
		{
			try 
			{
				threadList[i].join();
			}catch(InterruptedException ie){System.out.println("Couldn't Finish Thread");}
		}
		
		Thread printer = new PrinterThread(primeNumbers);
		printer.start();
		try 
		{
			printer.join();
		}catch(InterruptedException ie){System.out.println("Couldn't Finish Printer Thread");}
	}
	
	public static void main(String args[])
	{
		GetPrimeNumbers(10, 1000);
	}
}
