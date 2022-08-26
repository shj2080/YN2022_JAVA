package interface_abstract_inherit;

public class CompleteCalcMain {

	public static void main(String[] args) {
		CompleteCalc completeCalc = new CompleteCalc();
		
		int num1 = 10;
		int num2 = 3;
		
		//재정의된 메서드
		System.out.println("10+3=" + completeCalc.add(num1, num2));
		System.out.println("10-3=" + completeCalc.sub(num1, num2));
		System.out.println("10*3=" + completeCalc.mul(num1, num2));
		System.out.println("10/3=" + completeCalc.div(num1, num2));
		
		completeCalc.showInfo(); //CompleteCalc에서 추가된 메서드
		/*---------------------------------------------------------*/
		
		//부모 인터페이스 = 자식객체;
		Calc calc = completeCalc;
		calc.description(); //재정의
		
		int[] arr = {1,2,3,4,5};
		System.out.println("배열의 각 요소를 더한 값" + Calc.hap(arr)); //★주의:부모인터페이스.static멤버
		
		/*---------------------------------------------------------*/
		
		//부모 추상클래스 = 자식객체;
		Calculator calculator = completeCalc;
		calculator.description();
		
	}

}
