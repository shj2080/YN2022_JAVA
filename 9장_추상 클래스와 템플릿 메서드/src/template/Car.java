package template;

abstract public class Car { //부모 : 자식의 공통된 속성과 기능
	//1. 자식의 공통된 기능 - 미완성된 추상 메서드 : "반드시 자식에서 재정의"할 목적
	public abstract void drive();
	public abstract void wiper();
	public abstract void stop();
	
	//2. 자식의 공통된 기능 - 완성된 메서드 : "필요하면 자식에서 재정의"해서 사용하라~~
	//ManualCar:그대로 사용, AICar:"자동 세차" 재정의
	public void washCar() {}
	
	//3. 자식의 공통된 기능 - 완성된 메서드 : 그대로 상속받아 사용
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	//4. 자식의 공통된 기능 - ★템플릿 메서드 : 메서드 실행순서와 시나리오를 정의한 메서드, 클래스 설계단계에서 많이 사용
	//final을 앞에 두어 재정의할 수 없음을 강조함(이유?"반드시" 그대로 사용하는 메서드)
	final public void run() { //final : 작동 순서는 어느 차나 동일함. 실행순서, 즉 시나리오를 정의한 메서드를 재정의하면 안됨~
		startCar();
		
		drive();
		wiper();
		stop();
		
		turnOff();
		
		washCar(); 	//ManualCar는 실행되는 것이 없고, AICar는 "자동세차"
	}
}
