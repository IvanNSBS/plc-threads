package ArrayLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayLock extends Thread
{
	public static int[] vector = new int[50];
	public static Lock[] v = new ReentrantLock[vector.length];
	
	
	public static void main(String args[]) 
	{

	}
	
	public void run() 
	{
		
	}

	public void SetValue(int index, int value) 
	{
		if(index >= 0 && index < vector.length) 
		{
			v[index].lock();
			vector[index] = value;
			v[index].unlock();
		}
	}
	
	public void SwapValues(int index1, int index2) 
	{
		if( (index1 >= 0 && index1 < vector.length) && (index2 >= 0 && index2 < vector.length)) 
		{
			v[index1].lock();
			v[index2].lock();
			int temp = vector[index1];
			vector[index1] = vector[index2];
			vector[index2] = temp;
			v[index1].unlock();
			v[index2].unlock();
		} 
	}
	
	public void ReadValue(int index) 
	{
		if(index >= 0 && index < vector.length) 
		{
			v[index].lock();
			System.out.println(vector[index]);
			v[index].unlock();
		}
	}
	
}
