package PointOfSale;

public class Item {
	private String name;
	private int quantity;
	private double price;
	private int upc;
	private int threshold;
	private boolean isReorder = false;;
	
	public Item(int upc, String name, int quantity, double price, 
			int threshold, boolean isReorder){
		this.name=name;
		this.quantity=quantity;
		this.price=price;
		this.upc=upc;
		this.threshold = threshold;
		this.isReorder = isReorder;
	}
	public void addQuantity(int newQuantity){
		this.quantity+=newQuantity;
	}
	public void remveQuantity(int newQuantity){
		this.quantity-=newQuantity;
	}
	
	public String getName(){
		return this.name;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public double getPrice(){
		return this.price;
	}
	public int getUpc(){
		return this.upc;
	}
	public void setThreshold(int newThreshold){
		this.threshold=newThreshold;
	}
	public int getThreshold()
	{
		return this.threshold;
	}
	public boolean getIsReorder()
	{
		return this.isReorder;
	}
	public void setIsReorder(boolean bool)
	{
		this.isReorder = bool;
	}
	
}
