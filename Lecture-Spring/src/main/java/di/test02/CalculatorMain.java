package di.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalculatorMain {
	public static void main(String[] args) {
		
		ApplicationContext container = new GenericXmlApplicationContext("di/test02/beanConstructor02.xml");
		
		MyCalculator my = (MyCalculator)container.getBean("myCal");
		
		my.add();
		my.sub();
		my.mul();
		my.div();
		
		/*
		 * my.addition(); my.division(); my.substraction(); my.multiplication();
		 */
	}

}
