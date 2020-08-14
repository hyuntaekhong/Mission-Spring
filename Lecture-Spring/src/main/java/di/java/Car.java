package di.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	@Qualifier("hankook")
	private Tire tire;	//의존관계 발생
	
	public Car() {
		System.out.println("Car() 호출...");
	}
	
	// 생성자 주입(Constructor Injection)
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	
	// 속성주입(Setter Injection)
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출...");
	}
	
	public void prnTrieBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}
