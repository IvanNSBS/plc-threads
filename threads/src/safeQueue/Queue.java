package safeQueue;

public class Queue 
{
	public static Node root;
	public static Node last;
	
	public void Add(int pessoa)
	{
		synchronized(this) 
		{
			if(root == null) 
			{
				root = new Node();
				root.pessoa = pessoa;
				last = new Node();
				last = root;
				last.prev = null;
			}
			else
				Add(pessoa, root);
		}
	}
	
	private void Add(int pessoa, Node node) 
	{
		synchronized(this) 
		{
			if(node.next == null) 
			{
				node.next = new Node();
				node.next.pessoa = pessoa;
				last = node.next;
				last.prev = node;
			}
			else
				Add(pessoa, node.next);
		}
	}
	
	public void Remove() 
	{
		synchronized(this) 
		{
			if(root.next != null)
				root = root.next;
			else
				root = null;
		}
	}
	
	public void PrintQueue() 
	{
		PrintQueue(root);
	}
	
	private void PrintQueue(Node pessoa) 
	{
		if(pessoa == null) 
		{
			//System.out.println("Queue is empty");			
			return;
		}
		else
		{
			System.out.println(pessoa.pessoa);
			PrintQueue(pessoa.next);
		}
		if(pessoa == last)
			return;
	}
}
