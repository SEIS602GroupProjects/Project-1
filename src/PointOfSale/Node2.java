package PointOfSale;

public class Node2<T> {
	
	private T info; // current node
	private Node2<T> prev;
	private Node2<T> next;
	
	public Node2(T val)
	{
		info = val;
	}
	
	public T Data()
	{
		return info;
	}
	
	public void setData(T data)
	{
		info = data;
	}
	
	public Node2<T> getPrev()
	{	
		return prev;
	}
	
	public void setPrev(Node2<T> n)
	{
		prev = n;
	}
	
	public Node2<T> getNext()
	{	
		return next;
	}
	
	public void setNext(Node2<T> n)
	{
		next = n;
	}
	
}
