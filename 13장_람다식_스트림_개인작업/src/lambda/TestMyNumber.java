/*
 * 람다식 호출하는 메인
 */
package lambda;

public class TestMyNumber {

	public static void main(String[] args) {
		MyNumber max = (x, y) -> (x >= y) ? x : y;	//MyNumber타입의 max 변수에 람다식 대입 - MyNumber인터페이스의 getMax()메서드 구현
		/*
		 * (x >= y) ? x : y
		 * ▼아래 if문과 동일▼
		 * 
		 * if(x >= y)
		 * 	return x;
		 * else return y;
		 * 
		 */
		System.out.println(max.getMax(10, 20));
	}

}
