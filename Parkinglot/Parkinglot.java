interface Car{
	int width();
	int length();
}

class parkinglot{
	private int standardwidth = 2;
	private int standardlength = 2;
	
	public Parking(){
		
	}
	
	public Parking (int length,int width){
		this.length = length;
		this.width = width;
	}
	
	public void park(Car car){
		if(car.length()<=standardlength&&car.width()<=standardwidth){
			System.out.println("车可以停:"+car);
		}
		else{
			System.out.println("车不可以停:"+car);
		}
	}
}

class Bus implements Car{
	private static final int MAX_LENGTH = 4;
	private static final int MAX_WIDTH = 4;
	private int length = 4;
	
	
	public Bus(){}
	
	public Parking (int length,int width){
		this.length = length;
		this.width = width;
	}
	
	public Bus(){}
	
	
	public int length(){
		return 6;
	}
	public int width(){
		return 3;
	}
	
	//覆写了object类中的tostring();java所有类继承object类
	public String toString(){
		return "bus width="+this.width()+"bus length="+this.length();
	}
}

class Trunk implements Car{
	public int length(){
		return 4;
	}
	public int width(){
		return 9;
	}

}


public class Parkinglot{
	public static void main(String[] args) {
		Parking parking = new Parkinglot();
		
		Car[] cars = new Car[]{
			new Bus(),new Trunk();
		};
		for(int i = 0;i<cars.lentgh;i++){
			parking 
		}
	}
}