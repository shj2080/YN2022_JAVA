package stringbuilder;

/**
 * [StringBuilder와 StringBuffer 클래스]
 * 1. String 클래스
 * 	 //아래 2개 : 배열 선언 시 같은 표현
 * 	  private final char value[];
 * 	  private final char[] value;
 * 	 => String 클래스는 한번 생성되면 내부의 문자열 값이 변경되지 않기 때문에
 * 	 문자열 concat() 또는 +로 연결하거나
 * 	 subString() 등과 같은 메서드로 변경하면
 * 	 항상 "새로운 문자열 객체가 생성"되어 메모리의 낭비가 심하다.
 *
 *	※ 위 문제를 해결하기 위해서 StringBuilder와 StringBuffer 클래스 등장함
 *
 *	2. StringBuilder와 StringBuffer 클래스의 유일한 차이점
 *	 - StringBuilder : 싱글 쓰레드에서 사용 -> 속도 향상
 *	 - StringBuffer  : 멀티 쓰레드에서 사용 -> 동기화 보장
 */
public class StringBuilderTest { //373p_교재_참조

	public static void main(String[] args) {
		String javaStr = new String("Java");
		//처음 생성된 메모리 실제 주소
		System.out.println("[처음] javaStr 문자열 실제주소 : " + System.identityHashCode(javaStr));
		
		javaStr = javaStr.concat(" and JSP"); //문자열 연결
		System.out.println("[연결 후] javaStr 문자열 실제주소 : " + System.identityHashCode(javaStr));
		
		javaStr = javaStr.replace("Java", "Java program"); //문자열 대체
		System.out.println("[대체 후] javaStr 문자열 실제주소 : " + System.identityHashCode(javaStr));
		
		System.out.println(javaStr);
		
		System.out.println("----------------------------------------");
		
		/** 	StringBuilder 객체 생성 방법-1 **/
		//"Java and JSP" String으로부터 StringBuilder 객체 생성		
		//StringBuilder stringBuilder = new StringBuilder(javaStr);
		
		/** 	StringBuilder 객체 생성 방법-2 **/
		//StringBuilder stringBuilder = new StringBuilder(); //기본적으로 16개의 초기버퍼 만듦 char[16]
		StringBuffer stringBuilder = new StringBuffer(); //멀티쓰레드 일 때(StringBuffer 클래스타입으로 객체 생성, 문자열 다루는 메서드 활용은 동일)
		
		System.out.println("[처음] StringBuilder 실제주소 : " + System.identityHashCode(stringBuilder));
		
		//String에 concat()하고 싶은 것을 StringBuilder에 append()로 문자열 연결함
		stringBuilder.append("Java and JSP");	//버퍼에 문자열 추가
		stringBuilder.append(" and");
		stringBuilder.append(" android");
		
		//"Java" 를 "Java program"으로 바꾸는 방법-2가지
		//stringBuilder.insert(4, " program");			//[방법-1] index 4부터 " program" 삽입
		stringBuilder.replace(0, 3+1, "Java program");  //[방법-2] index 0~3 까지의 해당 문자열 "Java"를 "Java program"으로 변경
		
		//stringBuilder -> stringBuilder.toString() -> String -> String.toString()
		System.out.println(stringBuilder);
		
		stringBuilder.setCharAt(4, '2');   //index 4에 ' ' 대신 '2'로 변경		
		System.out.println(stringBuilder); //stringBuilder로 바로 출력 가능
		
		stringBuilder.delete(4, 4+1);//index 4의 '2' 삭제
		System.out.println(stringBuilder);
		
		System.out.println("stringBuilder의 총 문자 수 : " + stringBuilder.length());
		
		System.out.println("[최종 수정 후] StringBuilder 실제주소 : " + System.identityHashCode(stringBuilder));
		
		javaStr = stringBuilder.toString(); //추가할 문자열들을 다 추가 후 String객체로 변환
		System.out.println(javaStr);
		
		System.out.println("새로 만들어진 javaStr 문자열 실제 주소 : " + System.identityHashCode(javaStr));
		
	}

}
