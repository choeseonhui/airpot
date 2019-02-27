package airport.vo;

public class PassengerPlane extends Aircraft{
	
	private int maximunNumber;
	
public PassengerPlane(String flightNo, int flyingRange, String startDate, int maximunNumber){
	super(flightNo, flyingRange, startDate);
	this.maximunNumber = maximunNumber;
}

public PassengerPlane(){}

public int getMaximunNumber() {
	return maximunNumber;
}

public void setMaximunNumber(int maximunNumber) {
	this.maximunNumber = maximunNumber;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString() + ", ÃÖ´ëÁÂ¼®¼ö :" + this.maximunNumber;
}




}