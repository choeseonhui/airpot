package airport.manager;

import java.util.ArrayList;

import airport.vo.Aircraft;

public interface AirportManager {
	/**
	 * ���ο� �װ��� ������ ����Ѵ�.
	 * @param ac ����ϰ��� �ϴ� �װ���(������, ���۱�) ������ ���� Aircraft��ü. �����ȣ�� ������ ���� ���´�.
	 * @return ��Ͽ� �����ϸ� true��, �̹� ��ϵ� �����ȣ�� �װ��� ������ ����ϰ��� �� ��쿡�� ��Ͽ� �����Ͽ� false�� ��ȯ�Ѵ�.
	 * */
	public boolean addAircraft(Aircraft ac);
	
	/**
	 * �־��� �����ȣ�� ��ϵ� �װ��� ������ �˻��Ѵ�. 
	 * @param flightNo �˻��ϰ��� �ϴ� �װ����� �����ȣ. �����ȣ�� ������ ���� ���´�.
	 * @return �˻��� ���� ������ ���� Aircraft��ü. �˻� ����� ���� ��쿡�� null�� ��ȯ�Ѵ�.
	 * */
	public Aircraft searchAircraftByFlightNo(String flightNo);
	
	/**
	 * ���� ��¥�� ���� �������� ���� �ִ� �װ��� ��� �˻�
	 * @param today ���� ��¥�� ���� ������ ���� ���ڿ�. �� ������ �ݵ�� "YYYY. MM. DD"������ ���ؾ� �Ѵ�.
	 * @return ���� ��¥�� ���� �������� ���� �ټ��� �װ�����
	 * */
	public ArrayList<Aircraft> searchAircraftByStartDate(String today);
	
	/**
	 * �־��� ���� ��¥�� ����¥ ���̸� ���� �������� ���� �ִ� �װ��� ��� �˻�
	 * @param fromDate ��ȸ�ϰ��� �ϴ� ���� ������ ���� ��¥. �� ������ �ݵ�� "YYYY. MM. DD"������ ���ؾ� �Ѵ�.
	 * @param toDate ��ȸ�ϰ��� �ϴ� ���� ������ ������ ��¥. �� ������ �ݵ�� "YYYY. MM. DD"������ ���ؾ� �Ѵ�.
	 * */
	public ArrayList<Aircraft> searchAircraftByStartDate(String fromDate, String toDate);
	
	/**
	 * �־��� �����ȣ�� ��ϵ� �װ��� ������ �����Ѵ�.
	 * @param flightNo �����ϰ��� �ϴ� �װ����� �����ȣ. �����ȣ�� ������ ���� ���´�.
	 * @return ������ �����ϸ� true��, �����ϸ� false�� ��ȯ�Ѵ�.
	 * */
	public boolean deleteAircraft(String flightNo);
	
	/**
	 * ���ο� ������ ���� Aircraft��ü�� ���� ��ü ���� �����Ѵ�. �װ��� ������ ���� ���� ������ �׸�(�ʵ�)�� ������ ����.
	 * ������: �ִ� �¼� ��
	 * ���۱�: �ִ� ���緮
	 * @param ac ���ο� ������ ���� Aircraft��ü
	 * */
	public void updateAircraftInfo(Aircraft ac);
	
	/**
	 * ��ϵ� ��� �װ������� ������ �ִ� ArrayList��ü�� ��ȯ�Ѵ�.
	 * @return ��ϵ� ��� �װ������� ������ �ִ� ArrayList��ü
	 * */
	public ArrayList<Aircraft> getAllAircraftInfo();
	
}
