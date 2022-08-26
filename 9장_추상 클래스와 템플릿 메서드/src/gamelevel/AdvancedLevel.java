package gamelevel;

public class AdvancedLevel extends PlayerLevel{ //중급자 레벨

	@Override
	public void run() {
		System.out.println("빨리 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("높이 jump 합니다.");
	}

	@Override
	public void turn() {
		System.out.println("Turn할 줄 모르지롱.");
	}

	@Override
	public void showLevelMessage() {
		System.out.println("=======중급자 레벨입니다.=======");
	} 

	/* // 반드시 그대로 사용(재정의 불가능한 메서드)
	final public void go(int count) {
		run();
		
		for(int i = 1; i <= count; i++) {
			jump();
		}
		turn();
	}
	*/
}
