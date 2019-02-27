package airport.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;


import airport.manager.AirportManager;
import airport.vo.Aircraft;

public class AirportServerManager implements AirportManager {

	private ArrayList<Aircraft> aircraftList;
	private File file;
    private FileOutputStream fos;
    private FileInputStream fis;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	
public AirportServerManager() {
	
	file = new File("ses.dat");
	
	if(file.exists()){
		
		 this.saveData();
		
	}else{
		aircraftList = new ArrayList<Aircraft>();
		
		this.saveData();
		
	}
	
}


@Override
public boolean addAircraft(Aircraft ac) {
	
	
	boolean result = true;
	
	for(int i = 0 ;i< aircraftList.size(); i++){
		if(aircraftList.get(i).getFlightNo().equals(ac.getFlightNo())){
			result = false;
		}
	}
	
	if(result){
		aircraftList.add(ac);
	}

	
	
return result;
}
	

	


@Override
public Aircraft searchAircraftByFlightNo(String flightNo) {
	Aircraft result = null;
	
	if(file.exists()){
		
		this.readData();
				
	}
	for(int i =0;i < aircraftList.size(); i++){
		if(aircraftList.get(i).getFlightNo().equals(flightNo)){
			result = aircraftList.get(i);
			
		}
		
	}
	
	return result;
}



@Override
public ArrayList<Aircraft> searchAircraftByStartDate(String today) {
	
	ArrayList<Aircraft> startdate  = new ArrayList<Aircraft>();
	
	if(file.exists()){
		
		this.readData();
	}
	
	for(int i = 0; i<aircraftList.size(); i++){
		if(aircraftList.get(i).getStartDate().equals(today)){
			startdate.add(aircraftList.get(i));
			
		}
	}
	
	
	
	return startdate;
}
@Override
public ArrayList<Aircraft> searchAircraftByStartDate(String fromDate, String toDate) {
	ArrayList<Aircraft> fromtodate  = new ArrayList<Aircraft>();
	
	if(file.exists()){
		
		this.readData();
	}
	for(int i = 0; i<aircraftList.size(); i++){
		if(aircraftList.get(i).getStartDate().compareTo(fromDate)>=0 && aircraftList.get(i).getStartDate().compareTo(toDate)<= 0){
			fromtodate.add(aircraftList.get(i));
		}
	}
	
	
	return fromtodate;
}
@Override


public boolean deleteAircraft(String flightNo) {
	
	
	boolean result= false;
	if(file.exists()){
		
		this.readData();
	}
	for(int i =0; i<aircraftList.size(); i++){
		if(aircraftList.get(i).getFlightNo().equals(flightNo)){
			aircraftList.remove(i);
		}
	}
	
	
	
	return result;
}

@Override
public void updateAircraftInfo(Aircraft ac) {
	
	if(file.exists()){
		this.readData();
	}
	for(int i =0; i<aircraftList.size(); i++){
		if(aircraftList.get(i).equals(ac)){//
			aircraftList.set(i, ac);
		   this.saveData();
			
		}
	}
	
	
}

@Override
public ArrayList<Aircraft> getAllAircraftInfo() {
	
	ArrayList<Aircraft> result = null;
	
	if(file.exists()){
		this.readData();
	}
	result = aircraftList;
	
		return result;
}
		

	


public void saveData(){
	 
	try{
		
 fos= new FileOutputStream(file);
 oos = new ObjectOutputStream(fos);

 oos.writeObject(aircraftList);
		 
 
 oos.close();
 fos.close();
	 
	 }catch(Exception e){
		 
		 e.printStackTrace();
		
			 
	 }}



public void readData(){
 
	
	try{
	 
	 fis = new FileInputStream(file);
	 ois = new ObjectInputStream(fis);
	 
	 aircraftList =(ArrayList<Aircraft>)ois.readObject();
	 
	 fis.close(); 	 
	 ois.close();
	
	 
 }catch(Exception e){
	 e.printStackTrace();
 }}


	
}
