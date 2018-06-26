package threads;
import java.util.LinkedList;

public class PrinterThread extends Thread
{
	LinkedList<Integer> primeNumbers;
	
	PrinterThread(LinkedList<Integer> primeNumbers)
	{
		this.primeNumbers = primeNumbers;
	}
	
	public void run() 
	{
		for(int i = 0; i < primeNumbers.size(); i++)
			System.out.println(primeNumbers.get(i));
	}
}
