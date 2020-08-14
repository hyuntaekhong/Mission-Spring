package di.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorMain {
	public static void main(String[] args) {
		
		ApplicationContext container = new GenericXmlApplicationContext("di/test01/beanConstructor02.xml");
		
		MyCalculator my = (MyCalculator)container.getBean("myCal");
		
		my.setFirstNum(15);
		my.setSecondNum(4);
	
		/*
		 * my.addition(); my.division(); my.substraction(); my.multiplication();
		 */
	}

}
