package di.xml.n01;

public class Car {
	
	private Tire tire;	//의존관계 발생
	
	// 속성주입(Setter Injection)
	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public void prnTrieBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}
