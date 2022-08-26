package gamelevel;

public class SuperLevel extends PlayerLevel{ //고급자 레벨
	
	@Override
	public void run() {
		System.out.println("엄청 빨리 달립니다.");
	}

	@Override
	public void jump() {
		System.out.println("아주 높이 jump 합니다.");
	}

	@Override
	public void turn() {
		System.out.println("한 바퀴 turn 합니다.");
	}

	@Override
	public void showLevelMessage() {
		System.out.println("=======고급자 레벨입니다.=======");
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
