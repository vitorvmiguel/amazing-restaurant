package bts.mdsd.main;

/*
 * Main class for running the program and the menu of options
 * 
 * NOTE: THE MENU OPTIONS C AND E RETURN THE VALUES CORRECTLY BUT THEY RUN THE MENU AGAIN HIDING THE ANSWER, TRYING TO FIX IT
 * */

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
		
		// Menu parameters
		String inputMenu = "z";
		String inputString = null;
		Integer inputInteger = null;
		Operations operations = new Operations();
		List<Order> orders = new ArrayList<>();
		List<Dish<? extends Serializable>> dishes = new ArrayList<>();
		scan = new Scanner(System.in);
		
		// DEFAULT INPUT FILE TEST	'online_order_sample.csv' 
		
		// Menu declaration
		do {
			switch(inputMenu) {
			case "z":
				p("┌────────────────────────────────────────────────────────────────────────────┐");
				p("│ Chose the corresponding item by typing the index letter followed by Enter. │");
				p("└────────────────────────────────────────────────────────────────────────────┘");
				p("\n");
				p("	a - Import CSV");
				p("	b - Count the number of Orders");
				p("	c - Select order from index");
				p("	d - Retrieve all orders");
				p("	e - Select dish from index");
				p("	f - Retrieve all dishes");
				p("	g - Select all dishes of same type");
				p("	h - Select all dishes of same feature");
				p("	i - Percentage of dishes ordered that correspond to one type");
				p("\n");
				p("┌────────────────────────────────────────────────────────────────────────────┐");
				p("│      q - Exit program                                                      │");
				p("└────────────────────────────────────────────────────────────────────────────┘");
				p("\n");
				
				inputMenu = scan.nextLine().toLowerCase();
				break;
			case "a":
				p("\n******************************************************************************");
				p("\nType the filename and press Enter: ");
				inputString = scan.nextLine();
				orders = HandleCsv.readOrders(inputString);
				dishes = HandleCsv.createDishList(orders);
				p("\n*** File imported! ***");
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			case "b":	
				p("\n******************************************************************************");
				p("\nThe number of orders is: " + operations.getNumberOrders(orders));
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
				
	/*
	* I DON'T KNOW WHY AFTER RUNNING THE OPTION C IT DISPLAYS THE RESULT BUT, RUNS THE MENU AGAIN WITH AN INVALID INPUT
	* */	
					
			case "c":
				p("\n******************************************************************************");
				p("\nPlease type the index number corresponding to the order you want:");
				inputInteger = scan.nextInt();
				p("\nThe order belongs to: " + operations.getOrder(orders, inputInteger).getOrderCustomerName() + 
						", and is a, " + operations.getOrder(orders, inputInteger).getOrderDish());
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			case "d":
				p("\n******************************************************************************");
				p(operations.getAllOrdersToString(orders));
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
	/*
	* I DON'T KNOW WHY AFTER RUNNING THE OPTION E IT DISPLAYS THE RESULT BUT, RUNS THE MENU AGAIN WITH AN INVALID INPUT
	* */
			case "e":
				p("\n******************************************************************************");
				p("\nPlease type the index number corresponding to the order you want:");
				inputInteger = scan.nextInt();
				p("\nThe dish: " + operations.getDish(dishes, inputInteger).getDishName() + 
						" and is a, " + operations.getDish(dishes, inputInteger).getDishtype()  + 
						" gluten free dish: " + operations.getDish(dishes, inputInteger).isGfd()  + 
						" halal meat dish: " + operations.getDish(dishes, inputInteger).isHmd()  + 
						" sea food dish: " + operations.getDish(dishes, inputInteger).isSfd()  + 
						" vegetarian dish: " + operations.getDish(dishes, inputInteger).isVgd() + 
						" extra: " + operations.getDish(dishes, inputInteger).getExtra());
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			case "f":
				p("\n******************************************************************************");
				p(operations.getAllDishToString(dishes));
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			case "g":
				p("\n******************************************************************************");
				p("\nType the dish type (Starter, MainCourse, Dessert) and press Enter: ");
				inputString = scan.nextLine();
				p(operations.getDishesByType(dishes, inputString).toString());
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			case "h":
				p("\n******************************************************************************");
				p("\nType the dish feature (gfd, vgd, sfd, hmd) and press Enter: ");
				inputString = scan.nextLine();
				p(operations.getDishesByFeature(dishes, inputString).toString());
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			case "i":
				p("\n******************************************************************************");
				p("\nType the dish type (Starter, MainCourse, Dessert) and press Enter: ");
				inputString = scan.nextLine();
				p(operations.getStatsByDishType(dishes, inputString));
				p("\n******************************************************************************\n");
				inputMenu = "z";
				break;
			default:
				p("\n/*****************************************************************************/");
				p("/*    Unvalid option, please select one valid menu option again.             */");
				p("/*****************************************************************************/\n");
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
