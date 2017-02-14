package bts.mdsd.main;

import java.io.Serializable;

/*
 **Class defining the Customer Orders
 */

public class Order {

	private String orderCustomerName;
	private Dish <? extends Serializable> orderDish;
	
	
	public Order(String orderCustomerName, Dish<? extends Serializable> orderDish) {
		super();
		this.orderCustomerName = orderCustomerName;
		this.orderDish = orderDish;
	}
	public String getOrderCustomerName() {
		return orderCustomerName;
	}
	public void setOrderCustomerName(String orderCustomerName) {
		this.orderCustomerName = orderCustomerName;
	}
	public Dish<? extends Serializable> getOrderDish() {
		return orderDish;
	}
	public void setOrderDish(Dish<? extends Serializable> orderDish) {
		this.orderDish = orderDish;
	}
	
	


}
