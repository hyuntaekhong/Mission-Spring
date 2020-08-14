package di.anno.n02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
	
	@Autowired(required = false) // 객체 없어도 넘어가게 된다. 대신 tire가 없다면 nullpointerExeception 발생
	@Qualifier("hankook")
	private Tire tire;	//의존관계 발생
	
	public Car() {
		System.out.println("Car() 호출...");
	}
	
	// 생성자 주입(Constructor Injection)
	public Car(@Qualifier("kumho") Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire) 호출...");
	}
	
	// 속성주입(Setter Injection)
	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire) 호출...");
	}
	
	public void prnTrieBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}
