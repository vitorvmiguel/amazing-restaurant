package bts.mdsd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import bts.mdsd.main.Dessert;
import bts.mdsd.main.Dish;
import bts.mdsd.main.MainCourse;
import bts.mdsd.main.Order;
import bts.mdsd.main.Starter;

public class HandleCsv {
	
	public static List<Order> readOrders(String fileName) {
		
		List<Order> orders = new ArrayList<>();
		Path filePath = Paths.get(fileName);
		
		
		try (BufferedReader buffer = Files.newBufferedReader(filePath,
                StandardCharsets.US_ASCII)) {
			
			buffer.readLine();
			String line = buffer.readLine();
			
			while (line != null) {
				
		   		 String[] attributes = line.split(",");
						
				 Order order = createOrder(attributes);
				 
				 orders.add((Order) order);
				 
				 line = buffer.readLine();
				 
			}
			
		} catch (IOException ioe) {
            ioe.printStackTrace();
        }
			
		return orders;
		
	}

	private static Order createOrder(String[] attributes)  {
		String customerName = attributes[0];
		String dishName = attributes[1];
		String type = attributes[2];
		Boolean gfd = Boolean.valueOf(attributes[3]);
		Boolean vgd = Boolean.valueOf(attributes[4]);
		Boolean hmd = Boolean.valueOf(attributes[5]);
		Boolean sfd = Boolean.valueOf(attributes[6]);
		String extra =  attributes[7];
		
		switch(type){
		 case "st": 
			 return (Order) new Order(customerName, new Starter(dishName, gfd, vgd, hmd, sfd, extra));
		 case "mc":
			 return (Order) new Order(customerName, new MainCourse(dishName, gfd, vgd, hmd, sfd, extra));
		 case "ds":
			 return (Order) new Order(customerName, new Dessert(dishName, gfd, vgd, hmd, sfd, Integer.valueOf(extra)));
		 default:
			 return null;
			
		 }
	}
		
	public static List<Dish<? extends Serializable>> createDishList(List<Order> orderList)  {
		List<Dish<? extends Serializable>> dishList = new ArrayList<>();
		for(Order o: orderList){
			dishList.add(o.getOrderDish());
		}
		return dishList;
	}

}
