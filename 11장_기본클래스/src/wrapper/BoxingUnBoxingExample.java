/** [375p~ 참조]
 * Wrapper 클래스 : 기본 자료형(int, double...)을 위한 클래스
 * 				 자동 Boxing과 자동 UnBoxing이 됨
 * 
 * 1. 수와 관련된 Wrapper 클래스의 부모 : Number
 * 	  (int : Integer, double : Double ... 등)
 * 
 * 2. 수와 관련되지 않은 Wrapper 클래스(2개)의 부모 : Object
 * 	  (char : Character, boolean : Boolean)
 * 
 * 3. Character만 parseCharacter("문자열"); 메서드가 없다.
 * 	  (이유? "abc"(문자가 여러개)-> 문자 여러 개 중 1개만 선택하여 문자 1개로 변환할 수 없으므로...)
 * 	  그래서 String 클래스의 charAt(int index) 메서드로 문자열에서 특정 문자 1개를 추출함
 */
package wrapper;

public class BoxingUnBoxingExample {

	public static void main(String[] args) {
		System.out.println("******************* 자동 ********************");
		//자동 Boxing(기본타입 -> Wrapper 클래스로 자동변환) : Wrapper 클래스타입 = 기본타입값
		Integer i = 100;
		System.out.println(i.intValue()); //Integer -> int타입으로 변환
		System.out.println(i.toString()); //Integer
		
		//자동 UnBoxing('Wrapper 클래스 -> 기본타입' 로 자동변환) : 기본타입 = Wrapper 객체
		i = i + 7; //연산 : (자동 UnBoxing)Integer->int 100 + 7 = 107을 i에 저장시 "자동 Boxing"되어 저장됨
		
		int i2 = i; //Integer -> int
		System.out.println(i2); //int
		
		System.out.println("-- Number 테스트 --");
		
		Number number = 100; //"자동 Boxing : (int)100 -> (Integer)100" -> (Number)100
		System.out.println(number.toString());
		
		//연산시 자동Unboxing 안되는 이유? 수와 관련된 Wrapper 클래스가 여러 개 있으므로, 원하는 해당 자식클래스로 강제로 형변환해야 함
		if(number instanceof Integer) { 	//true
			Integer result = (Integer)number + 7;
			System.out.println("result=" + result);
		}
		
		//number는 Integer로 자동Boxing 된 것을 부모 클래스타입인 Number로 형변환한 것이므로▼
		//오류? ClassCastException: java.lang.Integer cannot be cast to java.lang.Double
		if(number instanceof Double) {
			Double result2 = (Double)number + 7;
			System.out.println("result2=" + result2);
		}
		
		System.out.println("******************* 수동 ********************");
		/* 수동 Boxing ------------------------- */
		//Integer 객체 생성 방법-2가지
		//[방법-1]생성자 이용 => 향후 버전에서 지원중단될 방법(Deprecated)
		Integer integer1 = new Integer(100); 
		Integer integer2 = new Integer("200");
		
		//Integer(String s) throws NumberFormatException
		try {
			Integer strInteger1 = new Integer("ab");
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println(e); //예외클래스종류 + 예외메세지
		}
		
		//[방법-2]valueOf() 메서드 이용
		Integer integer3 = Integer.valueOf(300); 	
		Integer integer4 = Integer.valueOf("400");
		
		//Integer.valueof(String s) throws NumberFormatException
		try {
			Integer strInteger2 = Integer.valueOf("가나");
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println(e); //예외클래스종류 + 예외메세지
		}
		
		/*---------------- 수동 UnBoxing ------------------------*/
		int value1 = integer1.intValue();
		int value2 = integer2.intValue();		
		
		int value3 = integer3; //자동UnBoxing
		int value4 = integer4; 
		
		/*---------- 출력 -----------------------*/
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		
		
		System.out.println("**** 문자열 -> 기본타입으로, 기본타입 -> 문자열로 ****");
		//문자열 -> 기본타입으로 : parse~(String s) throws NumberFormatException 발생할 가능성 -> 예외처리해야 함
		try {
			int iValue = Integer.parseInt("10");
			double d = Double.parseDouble("3.14");
		} catch (NumberFormatException e) {
			//e.printStackTrace();
			System.out.println(e); //예외클래스종류 + 예외메세지
		}
		
		/*
		  2. 수와 관련되지 않은 Wrapper 클래스(2개)의 부모 : Object
  	  		(char : Character, boolean : Boolean)
		 */
		Character character = 'a'; //자동 Boxing
		char ch2 = character;		//자동 UnBoxing
		//Number number2 = character; //오류? Number가 부모가 아니므로...
		Object object = character;	//ok? Object가 부모이므로...
		
		char ch3 = "abc".charAt(0);
		
		//기본타입 -> 문자열로
		String s1 = String.valueOf(10);
		String s2 = String.valueOf(123.45);
		String s3 = String.valueOf(false);
		String s4 = String.valueOf('A');
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		//IntegerCache 관련자료(아래 문제 발생원인) : https://blog.naver.com/seban21/221833304179
		//-128 ~ 127의 정수값은 IntegerCache객체가 미리 캐싱한 Integer객체를 참조함.
		/*********************************************************
		 * 포장 객체에 정확히 어떤 값이 저장될 지 모르는 상황이라면
		 * ==와 != 연산자는 사용하지 않는 것이 좋다.
		 * 
		 * 직접 내부 값을 intValue()로 수동 언박싱해서 비교(==와 != 연산자)하거나
		 * equals() 메서드로 내부값을 비교하는 것이 좋다.(=>권장)
		 * 
		 * 이미 포장 클래스는 equals() 메서드는 내부값을 비교하도록 재정의되어 있다.
		 *********************************************************/
		System.out.println(Byte.MAX_VALUE); //127
		System.out.println(Byte.MIN_VALUE); //-128
		
		System.out.println("[-128 ~ 127 이외의 값일 경우]");
		Integer b1 = 300; //자동 Boxing
		Integer b2 = 300;
		
		//★★자동 UnBoxing되어 값 비교 300==300 -> false(비정상적인 결과가 나옴) : ★주소 비교 아님
		System.out.println("==결과:" + (b1==b2));
		
		//intValue()로 수동UnBoxing하여 값 비교 -> true(정상적인 결과)
		System.out.println("언박싱 후 ==결과:" + (b1.intValue() == b2.intValue()));
		
		System.out.println("equals() 결과:" + b1.equals(b2)); //true(정상적인 결과)

		System.out.println("[-128 ~ 127 사이의 값일 경우]");
		Integer b3 = 10; //자동 Boxing
		Integer b4 = 10;
		
		//★★자동 UnBoxing되어 값 비교 10==10 -> true(정상적인 결과)
		System.out.println("==결과:" + (b3==b4));
		
		//intValue()로 수동UnBoxing하여 값 비교 -> true(정상적인 결과)
		System.out.println("언박싱 후 ==결과:" + (b3.intValue() == b4.intValue()));
		
		System.out.println("equals() 결과:" + b3.equals(b4)); //true(정상적인 결과)
		
	}

}
