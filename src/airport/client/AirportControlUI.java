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
		    		 
		    		System.out.println("���� ��� �Ǿ����ϴ�");
		    	 }else{
		    		 System.out.println("�̹� ��ϵ� ����� ��ȣ �Դϴ�.");
		    	 }
		    	 
		    	 
		    	 
		     }else if(num==3){
		    	 dude = false;
		    	 
		     }else{
		    	 System.out.println("���Է� �Ͻÿ�");
		     }
		     	
			}
			
			break;
		case 2:
			
			System.out.print("����� ��ȣ : ");
			String airportnum = sc.next();
			
			Aircraft output = manager.searchAircraftByFlightNo(airportnum);
			if(output!=null){
			output.toString();
			}else{
				System.out.println("�������� �ʽ��ϴ�");
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
							
				System.out.print("���� ��¥ (yyyy. mm. dd) : ");
				sc.nextLine();
				String fromDate = sc.nextLine();
				System.out.println("������ ��¥(yyyy. mm. dd): ");
				sc.nextLine();
				String toDate = sc.nextLine();
				ArrayList<Aircraft> result2 =  manager.searchAircraftByStartDate(fromDate, toDate);
				
				for(int i =0;i<result2.size();i++){
					result2.get(i).toString();
							
			}
				break;
			}
			else{
				System.out.println("���Է��Ͻÿ�");
			}
					
			
			break;
		case 4:
			System.out.print("����� ��ȣ : ");
			String deletenum = sc.next();
			boolean result3 = manager.deleteAircraft(deletenum);
			
			if(result3){
				System.out.println("���� �Ǿ����ϴ�");
			}else{
				System.out.println("���� ����");
			}
			
			
			
			break;
		case 5:
			
			System.out.println("������ ����� ��ȸ(�����ȣ):");
			String updatenum = sc.next();
			
			Aircraft updateAircraft = manager.searchAircraftByFlightNo(updatenum);
			
			if(updateAircraft instanceof PassengerPlane){
				
				PassengerPlane pp = (PassengerPlane)updateAircraft;
				
				System.out.println("�ִ� �¼� �� : ");
				
			   int max = sc.nextInt();
			    
			    pp.setMaximunNumber(max);
			    manager.updateAircraftInfo(pp);
			    
			    break;
				
			}
			else if(updateAircraft instanceof Transport){
				
				Transport tp = (Transport)updateAircraft;
				
				System.out.println("�ִ� ���緮(ton) : ");
				
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
				System.out.println("�ٽ� �Է� �Ͻÿ�");
				break;	
		
		}//swicth
		
		
		
	}//while
	
	
	}
	
	/**
	 * �������� ��ȸ �޴� ó��
	 * */
	private void searchByStartDate() {
		System.out.println("-------------------");
		System.out.println("       �������� ��ȸ        ");
		System.out.println("-------------------");
		System.out.println("1. ���� ��¥ ���� ��ȸ");
		System.out.println("2. �Է±Ⱓ ��¥ ���� ��ȸ");
		System.out.print(">�޴�����: ");
		
	}

	/**
	 * �װ��� ��� �޴� ó��
	 * */
	private void insertAircraft() {
		System.out.println("--------------");
		System.out.println("    �װ��� ���      ");
		System.out.println("--------------");
		System.out.println("1. ������ ���");
		System.out.println("2. ���۱� ���");
		System.out.println("3. �����޴�");
		System.out.print(">�޴�����: ");
		
	}
	
	
	

	/**
	 * �װ��� ��� �� �װ��� ������ ���� ��ü ������ �ʿ��� ������ �Է¹޾� Aircraft��ü�� �����Ͽ� ��ȯ
	 * �װ��� ������ ��ü ������ ���� �ʿ��� ���� ������ �Է¹��� �� �Ű������� ���� Ÿ��(1:������, 2:���۱�)�� ���� �ΰ����� ������ �߰��� �޾� ��ü�� �����Ѵ�.
	 * @param ����ϰ��� �ϴ� �װ��� ������ ���� �� (1:������, 2:���۱�)
	 * @return Ű����κ��� �Է¹��� ������ ���� ������ �װ��� ��ü
	 * */
	public Aircraft makeAircraft(int type) {
		Aircraft ac = null;
					
			System.out.println("����� ��ȣ : ");
			String flightNo = sc.next();
			
			System.out.println("�׼� �Ÿ� : " );
			int flyingRange = sc.nextInt();
			
			System.out.println("��߳�¥ : ");
			System.out.println("�Է� �� : yyyy. mm. dd");
			sc.nextLine();
			String startDate = sc.nextLine();
			
			if(type == 1){
					
				System.out.println("�ִ� �¼��� :  ");
			int maxnumber = sc.nextInt();
			
		PassengerPlane pp = new PassengerPlane(flightNo, flyingRange, startDate, maxnumber);
		
		
			}else if(type==2){
				
			System.out.println("�ִ� ���緮");
			int maxload = sc.nextInt();
		Transport tp = new Transport(flightNo, flyingRange, startDate, maxload);	
				
			}
		
			
			return ac;
				
		}
		
		
	

	/**
	 * ���θ޴� ���
	 * */
	private void printMainMenu(){
		System.out.println("-----------------------------");
		System.out.println("    Soft Engineer Airport    ");
		System.out.println("-----------------------------");
		System.out.println("1. �װ��� ���");
		System.out.println("2. �װ��� �˻�");
		System.out.println("3. �������� ��ȸ");
		System.out.println("4. �װ��� ����");
		System.out.println("5. �װ������� ����");
		System.out.println("6. ��ü���");
		System.out.println("7. ����");
		System.out.print(">�޴�����: ");
	}
}
