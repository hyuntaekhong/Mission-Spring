package di.basic;

public class DriverMain {
	
	public static void main(String[] args) {
		
		//Tire tire = new HankookTire();	// 의존성을 가진 객체를 다른 곳에서 만든다?
		Tire tire = new KumhoTire();
		
		
		//1. 생성자 주입
		//Car car = new Car(tire);

		Car car = new Car();
		car.setTire(tire);
		
		car.prnTrieBrand();
	}

}
