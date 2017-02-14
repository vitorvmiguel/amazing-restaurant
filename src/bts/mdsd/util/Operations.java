package bts.mdsd.util;

/*
 * Implementation of the interface OnlineOrderOps provided by Pablo
 * */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bts.mdsd.main.Dish;
import bts.mdsd.main.OnlineOrderOps;
import bts.mdsd.main.Order;

public class Operations implements OnlineOrderOps<Order, Dish <? extends Serializable>> {

	@Override
	public int getNumberOrders(List<Order> orderList) {
		return orderList.size();
	}

	@Override
	public Order getOrder(List<Order> orderList, int orderIndex) {	
		return orderList.get(orderIndex);
	}

	@Override
	public String getAllOrdersToString(List<Order> orderList) {
		String result = "";
		for(Order o: orderList){
			result += "Customer Name: " + o.getOrderCustomerName() + ", Customer dish choice: " + o.getOrderDish().getDishName() + " ; \n";
		}
		return result;
	}

	@Override
	public Dish<? extends Serializable> getDish(List<Dish<? extends Serializable>> dishList, int dishIndex) {
		return dishList.get(dishIndex);
	}

	@Override
	public String getAllDishToString(List<Dish<? extends Serializable>> dishList) {
		String result = "";
		for(Dish<? extends Serializable> d: dishList){
			result += "Dish Name: " + d.getDishName() + " Dish type: " + d.getDishtype() + " Dish extra: " + d.getExtra() + " ; \n";
		}
		return result;
	}

	@Override
	public List<Dish<? extends Serializable>> getDishesByType(List<Dish<? extends Serializable>> dishList,
			String dishType) {
		List<Dish<? extends Serializable>> filteredList = new ArrayList<Dish<? extends Serializable>>();
		for (Dish<? extends Serializable> d: dishList){
			if(d.getDishtype().equals(dishType)){
				filteredList.add(d);
			} 
		}
		return filteredList;	
	}

	@Override
	public List<Dish<? extends Serializable>> getDishesByFeature(List<Dish<? extends Serializable>> dishList,
			String feature) {
		List<Dish<? extends Serializable>> filteredList = new ArrayList<Dish<? extends Serializable>>();
		for (Dish<? extends Serializable> d: dishList){
			switch (feature) {
			case "gfd":
				if(d.isGfd()){
					filteredList.add(d);
				} 
				break;
			case "vgd":
				if(d.isVgd()){
					filteredList.add(d);
				} 
				break;
			case "hmd":
				if(d.isHmd()){
					filteredList.add(d);
				} 
				break;
			case "sfd":
				if(d.isSfd()){
					filteredList.add(d);
				} 
				break;
			}
			
		}
		return filteredList;
	}

	@Override
	public String getStatsByDishType(List<Dish<? extends Serializable>> dishList, String dishType) {
		int totalDishes = dishList.size();
		List<Dish<? extends Serializable>> filteredList = new ArrayList<Dish<? extends Serializable>>();
		for (Dish<? extends Serializable> d: dishList){
			if(d.getDishtype().equals(dishType)){
				filteredList.add(d);
			} 
		}
		int dishCount = filteredList.size();
		int result = (int) (dishCount*100.0f/totalDishes);
		return "The " + dishType + " corresponds to: " + result + "% of the dishes."; 
	}

	
	
}