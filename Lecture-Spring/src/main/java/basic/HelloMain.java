package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("beanContainer.xml");	//classpath(src/main/resources) 부터 읽어온다. 
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml");
		ApplicationContext context = new GenericXmlApplicationContext("classpath:beanContainer.xml");
		
		HelloSingle obj3 = context.getBean("hs", HelloSingle.class); //명시적 형변환 없이 사용 방법+
		HelloSingle obj4 = (HelloSingle)context.getBean("hs2");
		obj3.prnMsg();
		System.out.println(obj3);
		System.out.println(obj4);
		
		
		Hello obj = (Hello)context.getBean("hello"); //id가 "hello"인 객체 가져올 때 
		obj.prnMsg();
	
		Hello obj2 = (Hello)context.getBean("hello2");
		obj.prnMsg();
		
	}
}
