package TTree;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tree 
{
	public class Node
	{
		int key;
		Node left,right;
		private Lock l;
		Node()
		{
			l = new ReentrantLock();
		}
	}
	
	Node root;
	Tree(int key)
	{
		root = new Node();
		root.left = null;
		root.right = null;
		root.key = key;
	}
	
	private void Add(Node node, int key) 
	{
		boolean goRight = false;
		boolean inserted = false;
		if(key > node.key) 
		{
			goRight = true;
			if(node.right == null) 
			{
				node.l.lock();
				node.right = new Node();
				node.right.key = key;
				inserted = true;
				node.l.unlock();
			}

		}
		else 
		{
			if(node.left == null) 
			{
				node.l.lock();
				node.left = new Node();
				node.left.key = key;
				inserted = true;
				node.l.unlock();
			}
		}
		
		if(!inserted) 
		{
			if(goRight)
				Add(node.right, key);
			else
				Add(node.left, key);
		}
	}
	
	public void Add(int key) 
	{
		Add(root, key);
	}
	
}
