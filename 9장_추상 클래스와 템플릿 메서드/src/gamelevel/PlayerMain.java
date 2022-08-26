/**
 * Player가 있고 이 Player가 게임을 합니다.
 * 게임에서 Player가 가지는 레벨(3가지 : 초 중 고급)에 따라 할 수 있는 3가지 기능이 있습니다.
 * 바로 run(), jump(), turn()입니다.
 * 
 * -초급자 레벨 : 천천히 달림
 * -중급자 레벨 : 빠르게 달리고 높이 점프함
 * -고급자 레벨 : 더 빠르게 달리고 더 높이 점프하고 턴함
 */
package gamelevel;

public class PlayerMain {

	public static void main(String[] args) {
		Player p = new Player();
		p.play(1);
		
		p.upgradeLevel(new AdvancedLevel());
		p.play(2);
		
		p.upgradeLevel(new SuperLevel());
		p.play(3);
	}

}
