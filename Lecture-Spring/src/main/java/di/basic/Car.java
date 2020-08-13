package di.basic;

public class Car {
	
	private Tire tire;	//의존관계 발생
	
	public Car() {
		// 의존관계 설정
		// 다른 객체의 멤버변수를 가지고 있으면 의존관계가 있다고 말할 수 있다.
		//tire = new HankookTire();
		//tire = new KumhoTire();
	}
	
	// 생성자 주입(Constructor Injection) - 의존성을 낮춘다?
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	// 속성주입(Setter Injection)
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void prnTrieBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}
