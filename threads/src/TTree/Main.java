package TTree;

import java.util.Random;

public class Main 
{
	public static void main(String args[]) throws InterruptedException 
	{
		Tree tree = new Tree(53412);
		
		Thread[] t = new ThreeThread[50];
		for(int i = 0; i < t.length; i++) 
			t[i] = new ThreeThread(tree);	
		
		long n = System.nanoTime();
		for(int i = 0; i < t.length; i++) 
			t[i].start();
		
		for(int i = 0; i < t.length; i++) 
		{
			t[i].join();
		}
		System.out.println("With Threads: " + ((System.nanoTime() - n)/1000000000.0)+ "s");
		
		n = System.nanoTime();
		tree = new Tree(53412);
		for(int i = 0; i < t.length * 2000; i++) 
		{
			Random rand = new Random();
			int key = rand.nextInt();
			tree.Add(key);
		}
		
		System.out.println("Without Threads: " + ((System.nanoTime() - n)/1000000000.0) +"s");
	}
}
