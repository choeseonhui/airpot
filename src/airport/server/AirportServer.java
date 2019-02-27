package airport.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import airport.vo.Aircraft;


public class AirportServer {

private ServerSocket socket;
private Socket soc;
private ObjectOutputStream oos;
private ObjectInputStream  ois;
private AirportServerManager manager;



public AirportServer(){
	
	manager = new AirportServerManager();
	
	try{
		
			socket = new ServerSocket(7878);
			System.out.println("server start");
 
           soc = socket.accept();
      
       System.out.println(" client 접속 완료");
      
       oos = new  ObjectOutputStream(soc.getOutputStream());
      
       ois = new ObjectInputStream(soc.getInputStream());
	
      while(soc.isConnected()){
    	   	
    	
    	  Object [] oa = (Object[])ois.readObject();
    	  String one =(String)oa[0];
        	  
    	  switch(one){
    	  
    	  case "add" :
    		  
    		 Aircraft aircraft = (Aircraft)oa[1];
    		  boolean add = (boolean)manager.addAircraft(aircraft);
    		  oos.writeObject(add);
    		  
    		  
    		  break;
    	  case "searchnumber": 
    		  String number = (String)oa[1];
    		  Aircraft search = (Aircraft)manager.searchAircraftByFlightNo(number);
    		  oos.writeObject(search);
    		  
    		  break;
    		  
    	  case "searchtoday": 
    		 String todaynumber = (String)oa[1];
    		 ArrayList<Aircraft> today = (ArrayList<Aircraft>)manager.searchAircraftByStartDate(todaynumber);
    		 oos.writeObject(today);
    		   break;
    	  case "searchdate": 
    		  String fromdate = (String)oa[1];
    		  String todate = (String)oa[2];
    		  ArrayList<Aircraft> fromto = (ArrayList<Aircraft>)manager.searchAircraftByStartDate(fromdate, todate);
    		  oos.writeObject(fromto);
    		  
    		  break;
    		  
    	  case "delete": 
    		  String deletenumber = (String)oa[1];
    		  boolean  delete = (boolean)manager.deleteAircraft(deletenumber);
    		  oos.writeObject(delete);
    		  
    		  break;
    	  case "update": 
    		  Aircraft update = (Aircraft)oa[1];
    		 
    		manager.updateAircraftInfo(update);
    		 	    		  
    		  break;
    		  
    	  case "get": 
    		 
    		  ArrayList<Aircraft> getlist= (ArrayList<Aircraft>)manager.getAllAircraftInfo();
    		  oos.writeObject(getlist);
    		  
    		  break;
    	  
    	
    
    	  }//switch
    	
    	  
    	  
      
      }//while
      
	}catch(Exception e){
		  e.printStackTrace();
	  }
		
		
		
	}


		
	

		
    
	
	
	
	
	public static void main(String[] args) {
	
		AirportServer start = new AirportServer();
}
	}
