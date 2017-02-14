package bts.mdsd.main;

/*
 * Abstract class provided by Pablo, included properties, constructor and getters and setters
 * */
/*
 * Dish class is intended to organize all the dishes and provide methods and properties common to all subclasses
 * 
 * Dish <T> uses a generic type for the property extra, this is the solution applied for the implementation of different types of 
 * the properties extra such as String and Integer
 * */
public abstract class Dish <T> {
	
	/*
	 * The Dish properties are those provided by the exercise Dish Name (dishName), Gluten Free Dish (gfd), Vegetarian Dish (vgd),
	 * Halal Meat Dish (hmd) and Sea Food Dish (sfd)
	 * */
	
	private String dishName;
	private boolean gfd;
	private boolean vgd;
	private boolean hmd;
	private boolean sfd;
	
	/* 
	 * The Dish constructor utilizes the generic type T later defined on the child classes Starter, Dessert, MainCourse
	 * */
	
	public Dish(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, T extra) {
		this.dishName = dishName;
		this.gfd = gfd;
		this.vgd = vgd;
		this.hmd = hmd;
		this.sfd = sfd;
	}

	public String getDishName() { return dishName; }
	public void setDishName(String dName) { this.dishName = dName; }

	public boolean isGfd() { return gfd;}
	public void setGfd(boolean gfd) { this.gfd = gfd; }

	public boolean isVgd() { return vgd; }
	public void setVgd(boolean vgd) { this.vgd = vgd; }

	public boolean isHmd() { return hmd; }
	public void setHmd(boolean hmd) { this.hmd = hmd; }

	public boolean isSfd() { return sfd; }
	public void setSfd(boolean sfd) { this.sfd = sfd; }
	
	/*
	 * The abstract methods below oblige the child classes to implement the getters and setters for extra and DishType, which implies implementing
	 * a variable extra and DishType
	 * */
	public abstract T getExtra();
	public abstract void setExtra(T t);

	public abstract String getDishtype();
}

