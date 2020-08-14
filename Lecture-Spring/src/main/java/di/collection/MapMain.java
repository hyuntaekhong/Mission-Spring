package di.collection;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MapMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("di-collection02.xml");
		
		MapAddress map = context.getBean("map", MapAddress.class);
		
		Map<String, String> addrs = map.getAddress();
		
		// Map 객체 내의 key, value 값 가져오는 방법 3가지 체크
		Set<Entry<String, String>> address = addrs.entrySet();
		
		for(Entry<String, String> a : address) {
			System.out.println(a.getKey() + " : " + a.getValue());
		}
	}

}
