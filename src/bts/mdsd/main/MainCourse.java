package bts.mdsd.main;

public class MainCourse extends Dish <String> {

	private final String dishType = "Main Course";
	private String extra;
	
	public MainCourse(String dishName, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String extra) {
		super(dishName, gfd, vgd, hmd, sfd, extra);
	}

	@Override
	public String getExtra() {
		return this.extra;
	}

	@Override
	public void setExtra(String str) {
		this.extra = str;
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


