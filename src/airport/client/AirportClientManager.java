package airport.client;


import java.io.*;

import java.net.Socket;
import java.util.ArrayList;

import airport.manager.AirportManager;
import airport.vo.Aircraft;

public class AirportClientManager implements AirportManager {

private Socket soc;
private InputStream is;
private OutputStream os;
private ObjectOutputStream oos;
private ObjectInputStream ois;


	
public AirportClientManager() {
	
	try{
		soc = new Socket("Localhost", 7878);
		
		System.out.println("접속 완료");
		
		os = soc.getOutputStream();
		is =  soc.getInputStream();
		oos = new ObjectOutputStream(os);
		ois = new ObjectInputStream(is);
		
		
		
	}catch(Exception e){ 
		e.printStackTrace();
	}

}	
@Override
		public boolean addAircraft(Aircraft ac) {
	
	 		boolean result = false;
	 		
	 		Object[] add = {"add", ac};
	 	    result = (boolean)this.requestAndResponse(add);
	 			 		
			return result;
		}	
	
@Override
		public Aircraft searchAircraftByFlightNo(String flightNo) { 
	   		Aircraft result = null;
	   		
	   		Object[] searchnumber = {"searchnumber", flightNo};
	   		result = (Aircraft)this.requestAndResponse(searchnumber);
		
			return result;
		}




@Override
	public ArrayList<Aircraft> searchAircraftByStartDate(String today) {
	    ArrayList<Aircraft> result = null;
	    
	    Object[] searchtoday = {"searchtoday", today};
	    
	    result = (ArrayList<Aircraft>)this.requestAndResponse(searchtoday);
	
	
		return result;
	}
@Override
	public ArrayList<Aircraft> searchAircraftByStartDate(String fromDate, String toDate) {
	 ArrayList<Aircraft> result = null;
	 
	   Object[] searchdate = {"searchdate", fromDate, toDate};
	    
	    result = (ArrayList<Aircraft>)this.requestAndResponse(searchdate);
	 
	 return result;
	}
@Override
	public boolean deleteAircraft(String flightNo) {
	boolean result = false;
	
	Object[] delete = {"delete", flightNo};
	
	result = (boolean)this.requestAndResponse(delete);
	
	
		return result;
	}

@Override
	public void updateAircraftInfo(Aircraft ac) {
	
	Object[] update = {"update", ac};
	
	this.requestAndResponse(update);
			
	}

@Override
	public ArrayList<Aircraft> getAllAircraftInfo() {
	ArrayList<Aircraft> result = null;
	
	Object[] oa = {"get", null};
	
	 result= (ArrayList<Aircraft>)this.requestAndResponse(oa);
	 
	 
		return result;
	}



public Object requestAndResponse(Object[] date){
	Object num = null;
	
   
	try{
	
	oos.writeObject(date);
	
	num  = ois.readObject();// why.

	
}catch(Exception e){
	e.printStackTrace();
	
}
	
	return num;  	
  	
}


}
