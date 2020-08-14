package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java"})	//@Bean 대신 사용
@Configuration								// container에 올리기 위한 설정파일
public class Config {
	
	/*
	//@Bean(name="car")
	@Bean
	public Car car() {
		return new Car();
	}
	
	@Bean(name="kumho")
	public Tire kumhoTire() {
		return new KumhoTire();	//return 뒤의 new HankookTire를 컨테이너에 올린다.(메소드 명은 중요하지 않음)
	}

	// 한국타이어라는 객체를 만들게 하고 싶은 것
	// @Bean은 <bean class="di.java.HankookTire" id="hankookTire" />와 동일한 효과
	@Bean
	@Qualifier("hankook")		// name, qualifier 둘 다 사용할 수 있다.
	public Tire hankookTire() {
		return new HankookTire();	//return 뒤의 new HankookTire를 컨테이너에 올린다.(메소드 명은 중요하지 않음)
	}
	*/
}
