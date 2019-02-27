package airport.vo;

public class Transport extends Aircraft {
	
	private int maximunLoad;

	public Transport(String flightNo, int flyingRange, String startDate, int maximunLoad){
		super(flightNo, flyingRange, startDate);
		this.maximunLoad = maximunLoad;
		
	}

	public Transport(){}

	public int getMaximunLoad() {
		return maximunLoad;
	}

	public void setMaximunLoad(int maximunLoad) {
		this.maximunLoad = maximunLoad;
	}


	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString() + ",최대적재량 : " + this.maximunLoad;
			
		}

	}

