package gamelevel;

public class Player {
	//[포함순서-1] PlayerLevel은 추상클래스이지만 부모역할 가능
	private PlayerLevel level;//'PlayerLevel(플레이어레벨)'을 가진 선수(=>포함관계)
	
	public Player() {
		//[포함순서-2]
		//level = new PlayerLevel(); //오류?PlayerLevel은 추상클래스이므로 객체 생성안됨
		level = new BeginnerLevel();//초급 레벨부터 시작(PlayerLevel의 자식클래스)
		level.showLevelMessage();
	}
	
	public PlayerLevel getLevel() {
		return level;
	}
	
	/* BeginnerLevel객체, AdvancedLevel객체, SuperLevel객체
	 * -> 부모인 PlayerLevel타입으로 자동형변환되어 받아들임(부모<-자식 UpCasting)
	 */
	//public void setLevel(PlayerLevel level) { 
	public void upgradeLevel(PlayerLevel level) { 
		this.level = level;
		level.showLevelMessage(); //재정의된 메서드 호출
	}

	//[포함순서-3]외부에 노출된 버튼
	public void play(int count) {
		level.go(count); //실질적인 기능
	}
}
