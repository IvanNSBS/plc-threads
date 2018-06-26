package threads;
import java.util.LinkedList;

public class IsPrimeThread extends Thread
{
	int start, goal;
	LinkedList<Integer> primeNumbers;
	
	IsPrimeThread(int start, int goal, LinkedList<Integer> answers)
	{
		this.start = start;
		this.goal = goal;
		primeNumbers = answers;
	}
	
	public void run() 
	{
		for(int i = start; i < goal; i++) 
		{
			if(IsPrime(i))
				primeNumbers.add(i);
		}
	}
	
	public boolean IsPrime(int num) 
	{
		if(num > 0) 
		{
			for(int i = 1; i <= num; i++) 
			{
				if(!(i == 1 || i == num))
					if(num % i == 0)
						return false;
			}
			return true;
		}
		else
			return false;
	}
}
