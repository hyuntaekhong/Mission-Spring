package di.test01;

public class Calculator {
	
	public void addition(int firstNum, int secondNum) {
		int result = firstNum + secondNum;
		System.out.println("덧셈 : " + result);
	}
	
	public void substraction(int firstNum, int secondNum) {
		int result = firstNum - secondNum;
		
		System.out.println("뺄셈 : " + result);
	}
	
	public void division(int firstNum, int secondNum) {
		int result = firstNum / secondNum;
		
		System.out.println("나눗셈 : " + result);
	}
	
	public void multiplication(int firstNum, int secondNum) {
		int result = firstNum * secondNum;
		
		System.out.println("곱셈 : " + result);
	}
}
