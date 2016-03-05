package PointOfSale;

public class Items {
	private String name;
	private int quantity;
	private double price;
	private int upc;
	
	public Items(String name, int quantity, double price, int upc){
		this.name=name;
		this.quantity=quantity;
		this.price=price;
		this.upc=upc;
	}
	public void addQuantity(int newQuantity){
		this.quantity+=newQuantity;
	}
	public void remveQuantity(int newQuantity){
		this.quantity=quantity-newQuantity;
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
}
