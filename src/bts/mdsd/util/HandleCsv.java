package bts.mdsd.util;

/*
 * HandleCsv is an utility class used for opening the Csv files and creating lists of objects from that
 * */

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
	
	/*
	 * Method readOrders receive the imput of the file name and searchs for it
	 * */
	public static List<Order> readOrders(String fileName) {
		
		//declaration of the list of orders to be filled from the csv
		List<Order> orders = new ArrayList<>();
		//finding the path to the file input
		Path filePath = Paths.get(fileName);
		// try catch block is used to create a buffer reading each single line of the csv file
		// and handling possible exceptions without crashing the code
		try (BufferedReader buffer = Files.newBufferedReader(filePath,
                StandardCharsets.US_ASCII)) {
			// skiping the first line
			buffer.readLine();
			String line = buffer.readLine();
			// reading lines while they are not null
			while (line != null) {
				// spliting the lines on commas the attributes into an array of strings 
		   		 String[] attributes = line.split(",");
				// calling the method to create the Order object from the string arrays		
				 Order order = createOrder(attributes);
				 // adding the Order objects to the list of orders 
				 orders.add((Order) order);
				 // reads next line for continuing iteration 
				 line = buffer.readLine();
				 
			}
			
		} catch (IOException ioe) {
            ioe.printStackTrace();
        }
			// return the list of orders
		return orders;
		
	}
	// method createOrders parse the string arrays read into Order objects, which depending on the type of Dish also diferentiate
	// the Dish object created
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
	// method createDishList returns a list of dishes from parsing the list of orders	
	public static List<Dish<? extends Serializable>> createDishList(List<Order> orderList)  {
		List<Dish<? extends Serializable>> dishList = new ArrayList<>();
		for(Order o: orderList){
			dishList.add(o.getOrderDish());
		}
		return dishList;
	}

}
