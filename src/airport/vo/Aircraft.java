package airport.vo;

import java.io.Serializable;

public class Aircraft implements Serializable, Comparable<Aircraft>{
	
	
	private String flightNo;
	private int flyingRange;
	private String startDate;
	
public Aircraft(String flightNo, int flyingRange, String startDate){
	this.flightNo = flightNo;
	this.flyingRange = flyingRange;
	this.startDate = startDate;
	
}

public Aircraft(){}

public String getFlightNo() {
	return flightNo;
}

public void setFlightNo(String flightNo) {
	this.flightNo = flightNo;
}

public int getFlyingRange() {
	return flyingRange;
}

public void setFlyingRange(int flyingRange) {
	this.flyingRange = flyingRange;
}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}


public String toString(){
	
	return  "�����ȣ" + this.getFlightNo() +" ,�׼ӰŸ�"+  this.getFlyingRange() +",��߳�¥" + this.getStartDate();
}

@Override
public int compareTo(Aircraft o) {
	// TODO Auto-generated method stub
	return this.getStartDate().compareTo(o.getStartDate());
}

}
