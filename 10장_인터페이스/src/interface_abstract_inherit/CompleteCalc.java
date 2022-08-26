package interface_abstract_inherit;

public class CompleteCalc extends Calculator{
	//추상메서드(2개) 재정의, 나머지는 그대로 상속
	@Override
	public int mul(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public double div(int num1, int num2) {
		if(num2 != 0) { //num2가 0이 아닐 때
			return (double)num1 / num2;
		} else return Calc.ERROR;	
	}
	
	//추가
	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현하였습니다.");
	}

	//default 메서드 : 필요시 재정의
	@Override
	public void description() {
		System.out.println("계산기를 구현합니다.(필요시 재정의)");
	}
	
	
}
