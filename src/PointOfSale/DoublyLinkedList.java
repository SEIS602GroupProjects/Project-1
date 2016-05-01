package PointOfSale;

import PointOfSale.Node2;

public class DoublyLinkedList<T> {

	private Node2<T> head;
	private Node2<T> tail;
	private int size;
	
	// Add head and tail accessors for purpose of stack/queue?
	
	public DoublyLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size()
	{
		return size;
	}
	
	public Node2<T> GetHead()
	{
		return head;
	}
	
	public Node2<T> GetTail()
	{
		return tail;
	}
	
	public void AddLast(T data) 
	{
		//Node2<T> curNode = head;
		Node2<T> tmp = new Node2<T>(data); 
		if (head == null)
		{
			head = tmp;
			tail = tmp;
			tmp.setNext(null);
			tmp.setPrev(null);
		}
		else
		{
			tail.setNext(tmp);
			tmp.setPrev(tail);
			tail = tmp;
			//curNode.setNext(tmp);
			//tail = curNode.getNext();
		}
		size++;
	}
	
	public void AddFirst(T data) 
	{
		//Node2<T> curNode = head;
		Node2<T> tmp = new Node2<T>(data); 
		if (head == null)
		{
			head = tmp;
			tail = tmp;
			tmp.setNext(null);
			tmp.setPrev(null);
		}
		else
		{
			head.setPrev(tmp);
			tmp.setNext(head);
			head = tmp;
			//curNode.setNext(tmp);
			//tail = curNode.getNext();
		}
		size++;
	}
	
	public void Add(T data, int index) 
	{
		if (index > size || index < 0)
		{
			System.out.println("Add: ERROR input outside of List range, try again");
			return;
		}
		
		Node2<T> tmp = new Node2<T>(data);
		if (index == 0)
		{
			if (head != null)
			{
				head.setPrev(tmp);
				tmp.setNext(head);
			}
			head = tmp;
		}
		else if (index == size())
		{
			if (tail != null)
			{
				tail.setNext(tmp);
				tmp.setPrev(tail);
			}
			tail = tmp;
		}
		else
		{
			Node2<T> prevNode = GetNode(index-1);			
			tmp.setNext(prevNode.getNext());
			prevNode.getNext().setPrev(tmp);
			tmp.setPrev(prevNode);
			prevNode.setNext(tmp);
		}
		
		if (index == size)
		{
			tail = tmp;
		}
		
		size++;
	}
	
	// String[] s = { "s", "ss", "sss", "" }
	// getNode(2) == s[2]
	// for (i=0; i < s.length; i++)
	// 		if (s[i] == "sss")
	//			return s[i];
	// for (i=0; i < size; i++)
	// 		if (getNode(i).Data() = "sss")
	//			return getNode(i).Data();
	
	
	public boolean Remove(int index)
	{
		if (index >= size || index < 0)
		{
			System.out.println("ERROR input outside of List range, try again");
			return false;
		}
		Node2<T> tmp;
		if (index == 0)
		{
			tmp = GetNode(index);
			head = tmp.getNext();
			head.setPrev(null);
			tmp = null;
		}
		else if (index == (size()-1))
		{
			tmp = GetNode(size()-1);
			tail = tmp.getPrev();
			tail.setNext(null);
			tmp = null;
		}
		else
		{
			tmp = GetNode(index);
			tmp.getPrev().setNext(tmp.getNext());
			tmp.getNext().setPrev(tmp.getPrev());
			tmp = null;
		}
		
		size--;
		return true;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public Node2<T> GetNode(int index)
	{
		if (index > size || index < 0)
		{
			System.out.println("Node: ERROR input outside of List range, try again");
			return null;
		}
		Node2<T> tmp = head;
		
		for (int i = 0; i < index; i++)
		{
			tmp = tmp.getNext();
		}
		
		return tmp;
	}
	
	public Node2<T> FindNode(T data)
	{
		Node2<T> tmp = head;
		
		while (tmp != null)
		{
			if (tmp.Data() == data)
			{
				return tmp;
			}
			tmp = tmp.getNext();
		}
		
		return null;
	}
	
	
	// print out list of elements
	public String toString()
	{
		String s = "";
		for (int i = 0; i < size; i++)
		{
			s += "Node " + (i+1) + ": " + GetNode(i).Data() + "\n";
		}

		return s;
	}
	
	
}
