package thread11last;
import java.util.LinkedList;

public class Slide11Last
{
	public static void main (String args[]) 
	{
		Thread t0 = new TCounterLoc(2000);
		Thread t1 = new TCounterLoc(2000);
		
		t0.start();
		t1.start();
	}
}
