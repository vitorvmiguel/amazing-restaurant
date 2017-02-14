package bts.mdsd.main;

/*
 * Dessert is one extension of Dish and the generic type used is Integer, no particular details besides of implementing
 *  the abstract class
 *  */

public class Dessert extends Dish <Integer> {
	
	private final String dishType = "Dessert";
	private Integer extra;

	public Dessert(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, Integer extra) {
		super(dishName, gfd, vgd, hmd, sfd, extra);
	}

	@Override
	public Integer getExtra() {
		return this.extra;
	}

	@Override
	public void setExtra(Integer itr) {
		this.extra = itr;
	}
	
	@Override
	public String getDishtype() {
		return dishType;
	}
	
	@Override
	public String toString() {
		return "Dish type is: " + this.dishType + ", and the dish name is: " + this.getDishName() ;
	}
	
	

}
