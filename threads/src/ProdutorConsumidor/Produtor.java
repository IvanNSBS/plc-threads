package ProdutorConsumidor;

import java.util.Random;

public class Produtor implements Runnable
{
	private Drop drop;
	
	Produtor(Drop drop){ this.drop = drop; }
	
	public void run() 
	{
		String messages[] = 
		{
			"Primeira msg",
			"Segunda msg",
			"Terceira msg",	
			"Quarta msg"
		};
		
		Random random = new Random();
		for(int i = 0; i < messages.length; i++) 
		{
			drop.put(messages[i]);
			try {
				Thread.sleep(random.nextInt(500));
			}catch (InterruptedException ie) {}
		}
		drop.put("Fim");
	}
}
