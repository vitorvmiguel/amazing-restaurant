package bts.mdsd.util;

import java.io.Serializable;
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
			result += "Customer Name: " + o.getOrderCustomerName() + " Customer dish choice: " + o.getOrderDish().getDishName() + " , ";
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
			result += "Dish Name: " + d.getDishName() + " Dish type: " + d.getDishtype() + " Dish extra: " + d.getExtra() + " , ";
		}
		return result;
	}

	@Override
	public List<Dish<? extends Serializable>> getDishesByType(List<Dish<? extends Serializable>> dishList,
			String dishType) {
		List<Dish<? extends Serializable>> filteredList = null;
		for (Dish<? extends Serializable> d: dishList){
			if(d.getDishtype().equals(dishType)){
				filteredList.add(d);
			} 
		}
		return filteredList;
				
				//Lists.newArrayList(Collections2.filter(dishList, Predicates.containsPattern(dishType)));
	//	return dishList.removeIf(s -> !s.contains(dishType));
		
	}

	@Override
	public List<Dish<? extends Serializable>> getDishesByFeature(List<Dish<? extends Serializable>> dishList,
			String feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatsByDishType(List<Dish<? extends Serializable>> dishList, String dishType) {
		int totalDishes = dishList.size();
		List<Dish<? extends Serializable>> filteredList = null;
		for (Dish<? extends Serializable> d: dishList){
			if(d.getDishtype().equals(dishType)){
				filteredList.add(d);
			} 
		}
		int dishCount = filteredList.size();
		return "The " + dishType + " corresponds to: " + ((dishCount/totalDishes)*100) + "%"; 
	}

	
	
}