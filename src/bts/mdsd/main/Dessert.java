package bts.mdsd.main;

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
		return "Dish type is: " + this.dishType + " The dish name is: " + this.getDishName() ;
	}
	
	

}
