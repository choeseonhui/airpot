package airport.client;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import airport.vo.Aircraft;
import airport.vo.PassengerPlane;
import airport.vo.Transport;

public class AirportControlUI {
	AirportClientManager manager;
	Scanner sc;
	
	
	public AirportControlUI(){
	
	manager = new AirportClientManager();
	sc= new Scanner(System.in);
	
	boolean flag = true;
	
	while(flag){
		
		this.printMainMenu();
		int a = sc.nextInt();
		
		switch(a){
		
		case 1:
			
			boolean dude = true;
			while(dude){
			this.insertAircraft();
			
			int num = sc.nextInt();
		    
			if(num==1||num==2){
		    	 
		    	 Aircraft result = this.makeAircraft(num);
		    	 
		    	 boolean add = manager.addAircraft(result);
		    	 
		    	 if(add){
		    		 
		    		System.out.println("정상 등록 되었습니다");
		    	 }else{
		    		 System.out.println("이미 등록된 비행기 번호 입니다.");
		    	 }
		    	 
		    	 
		    	 
		     }else if(num==3){
		    	 dude = false;
		    	 
		     }else{
		    	 System.out.println("재입력 하시오");
		     }
		     	
			}
			
			break;
		case 2:
			
			System.out.print("비행기 번호 : ");
			String airportnum = sc.next();
			
			Aircraft output = manager.searchAircraftByFlightNo(airportnum);
			if(output!=null){
			output.toString();
			}else{
				System.out.println("존재하지 않습니다");
			}
			
						
			break;
		
		case 3:
			this.searchByStartDate();
			int select = sc.nextInt();
			
			if(select == 1){
				Date date = new Date();				
				ArrayList<Aircraft> result = manager.searchAircraftByStartDate(DateFormat.getDateInstance().format(date));
				
				for(int i =0;i<result.size();i++){
					result.get(i).toString();
				}
				
				break;
			}
			else if(select==2){
							
				System.out.print("시작 날짜 (yyyy. mm. dd) : ");
				sc.nextLine();
				String fromDate = sc.nextLine();
				System.out.println("마지막 날짜(yyyy. mm. dd): ");
				sc.nextLine();
				String toDate = sc.nextLine();
				ArrayList<Aircraft> result2 =  manager.searchAircraftByStartDate(fromDate, toDate);
				
				for(int i =0;i<result2.size();i++){
					result2.get(i).toString();
							
			}
				break;
			}
			else{
				System.out.println("재입력하시오");
			}
					
			
			break;
		case 4:
			System.out.print("비행기 번호 : ");
			String deletenum = sc.next();
			boolean result3 = manager.deleteAircraft(deletenum);
			
			if(result3){
				System.out.println("삭제 되었습니다");
			}else{
				System.out.println("삭제 실패");
			}
			
			
			
			break;
		case 5:
			
			System.out.println("수정할 비행기 조회(비행번호):");
			String updatenum = sc.next();
			
			Aircraft updateAircraft = manager.searchAircraftByFlightNo(updatenum);
			
			if(updateAircraft instanceof PassengerPlane){
				
				PassengerPlane pp = (PassengerPlane)updateAircraft;
				
				System.out.println("최대 좌석 수 : ");
				
			   int max = sc.nextInt();
			    
			    pp.setMaximunNumber(max);
			    manager.updateAircraftInfo(pp);
			    
			    break;
				
			}
			else if(updateAircraft instanceof Transport){
				
				Transport tp = (Transport)updateAircraft;
				
				System.out.println("최대 적재량(ton) : ");
				
				int maxload = sc.nextInt();
				tp.setMaximunLoad(maxload);
				
				manager.updateAircraftInfo(tp);
				
				break;
			}
		
			
			break;
		case 6:
			
			manager.getAllAircraftInfo();
			
			
			
			break;
		case 7:
			flag = false;
			System.exit(0);
			
			break;
		
			default :
				System.out.println("다시 입력 하시오");
				break;	
		
		}//swicth
		
		
		
	}//while
	
	
	}
	
	/**
	 * 비행일정 조회 메뉴 처리
	 * */
	private void searchByStartDate() {
		System.out.println("-------------------");
		System.out.println("       비행일정 조회        ");
		System.out.println("-------------------");
		System.out.println("1. 오늘 날짜 출항 조회");
		System.out.println("2. 입력기간 날짜 출항 조회");
		System.out.print(">메뉴선택: ");
		
	}

	/**
	 * 항공기 등록 메뉴 처리
	 * */
	private void insertAircraft() {
		System.out.println("--------------");
		System.out.println("    항공기 등록      ");
		System.out.println("--------------");
		System.out.println("1. 여객기 등록");
		System.out.println("2. 수송기 등록");
		System.out.println("3. 상위메뉴");
		System.out.print(">메뉴선택: ");
		
	}
	
	
	

	/**
	 * 항공기 등록 시 항공기 종류에 따른 객체 생성에 필요한 정보를 입력받아 Aircraft객체를 생성하여 반환
	 * 항공기 종류별 객체 생성을 위해 필요한 공통 정보를 입력받은 후 매개변수로 받은 타입(1:여객기, 2:수송기)에 따른 부가적인 정보를 추가로 받아 객체를 생성한다.
	 * @param 등록하고자 하는 항공기 종유의 구분 값 (1:여객기, 2:수송기)
	 * @return 키보드로부터 입력받은 정보를 통해 생성된 항공기 객체
	 * */
	public Aircraft makeAircraft(int type) {
		Aircraft ac = null;
					
			System.out.println("비행기 번호 : ");
			String flightNo = sc.next();
			
			System.out.println("항속 거리 : " );
			int flyingRange = sc.nextInt();
			
			System.out.println("출발날짜 : ");
			System.out.println("입력 예 : yyyy. mm. dd");
			sc.nextLine();
			String startDate = sc.nextLine();
			
			if(type == 1){
					
				System.out.println("최대 좌석수 :  ");
			int maxnumber = sc.nextInt();
			
		PassengerPlane pp = new PassengerPlane(flightNo, flyingRange, startDate, maxnumber);
		
		
			}else if(type==2){
				
			System.out.println("최대 적재량");
			int maxload = sc.nextInt();
		Transport tp = new Transport(flightNo, flyingRange, startDate, maxload);	
				
			}
		
			
			return ac;
				
		}
		
		
	

	/**
	 * 메인메뉴 출력
	 * */
	private void printMainMenu(){
		System.out.println("-----------------------------");
		System.out.println("    Soft Engineer Airport    ");
		System.out.println("-----------------------------");
		System.out.println("1. 항공기 등록");
		System.out.println("2. 항공기 검색");
		System.out.println("3. 비행일정 조회");
		System.out.println("4. 항공기 삭제");
		System.out.println("5. 항공기정보 수정");
		System.out.println("6. 전체출력");
		System.out.println("7. 종료");
		System.out.print(">메뉴선택: ");
	}
}
