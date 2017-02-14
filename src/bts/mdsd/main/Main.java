package bts.mdsd.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bts.mdsd.util.HandleCsv;
import bts.mdsd.util.Operations;

public class Main {

	private static Scanner scan;
	
	public static void p(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) throws Exception {
		
		String inputMenu = "z";
		String inputString = null;
		Integer inputInteger = null;
		Operations operations = new Operations();
		List<Order> orders = new ArrayList<>();
		List<Dish<? extends Serializable>> dishes = new ArrayList<>();
		scan = new Scanner(System.in);
		
		//	online_order_sample.csv

		do {
			switch(inputMenu) {
			case "z":
				p("Chose the corresponding item by typing the index number followed by Enter.");
				p("----------------------------------------------------------------------------\n\n");
				p("a - Import CSV");
				p("b - Count the number of Orders");
				p("c - Select order from index");
				p("d - Retrieve all orders");
				p("e - Select dish from index");
				p("f - Retrieve all dishes");
				p("g - Select all dishes of same type");
				p("h - Select all dishes of same feature");
				p("i - Percentage of dishes ordered that correspond to one type");
				p("\n ----------------------------------------------------------------------------");
				p("\nq - Exit program");
				
				p("\n ----------------------------------------------------------------------------");
				
				inputMenu = scan.nextLine();
				break;
			case "a":
				p("\nType the filename and press Enter: ");
				inputString = scan.nextLine();
				orders = HandleCsv.readOrders(inputString);
				dishes = HandleCsv.createDishList(orders);
				p("\nFile imported!");
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "b":	
				p("\nThe number of orders is: " + operations.getNumberOrders(orders));
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "c":
				p("\nPlease type the index number corresponding to the order you want:");
				inputInteger = scan.nextInt();
				p("\nThe order belongs to: " + operations.getOrder(orders, inputInteger).getOrderCustomerName() + 
						" and is a, " + operations.getOrder(orders, inputInteger).getOrderDish());
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "d":
				p(operations.getAllOrdersToString(orders));
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "e":
				p("\nPlease type the index number corresponding to the order you want:");
				inputInteger = scan.nextInt();
				p("\nThe dish: " + operations.getDish(dishes, inputInteger).getDishName() + 
						" and is a, " + operations.getDish(dishes, inputInteger).getDishtype()  + 
						" gluten free dish: " + operations.getDish(dishes, inputInteger).isGfd()  + 
						" halal meat dish: " + operations.getDish(dishes, inputInteger).isHmd()  + 
						" sea food dish: " + operations.getDish(dishes, inputInteger).isSfd()  + 
						" vegetarian dish: " + operations.getDish(dishes, inputInteger).isVgd() + 
						" extra: " + operations.getDish(dishes, inputInteger).getExtra());
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "f":
				p(operations.getAllDishToString(dishes));
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "g":
				p("\nType the dish type (Starter, MainCourse, Dessert) and press Enter: ");
				//inputString = scan.nextLine();
				//p(dishes.get(0).getDishtype());
				p(operations.getDishesByType(dishes, "Starter").toString());
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "h":
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			case "i":
				p("\n ----------------------------------------------------------------------------");
				inputMenu = "z";
				break;
			default:
				p("Unvalid option, please select one valid menu option again.");
				if(inputMenu == "q"){
					inputMenu = "q";
				} else {
					inputMenu = "z";
				}
				break;
			}
		} while (!inputMenu.equals("q"));

		p("Program finished");
	}

}
