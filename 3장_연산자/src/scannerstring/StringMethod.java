package scannerstring;

import java.util.Scanner;

public class StringMethod {

	public static void main(String[] args) {
		String s1 = "";		//값이 없는 문자열 객체 생성.	length():문자의 수 0
		String s2 = null;		//null:클래스타입에만(s2가 참조하는 문자열객체가 없다.)
		
		//String 객체 생성 2가지 방법
		String str1 = "문자열 상수";				//1."문자열 상수"로 객체 생성 -> "공유 상수 풀"에 등록
		String str2 = "문자열 상수";
		String str3 = new String("문자열 상수");	//2.new 생성자();호출하여 객체 생성
		
		System.out.println(str1);		//str1:String 객체의 주소=>주소가 참조하는 값이 출력
		//Object의 toString()메서드를 대부분의 라이브러리 클래스에서는 재정의하여 우리에게 제공함
		System.out.println(str1.toString()); 	//결과로 "문자열 상수" 출력(재정의된 toString()호출한 결과임)
		
		//str1주소 == str2주소 : 주소비교 => true
		if(str1 == str2) System.out.println("같은 주소이므로 같은 문자열객체를 참조한다.");
		else System.out.println("다른 주소이므로 다른 문자열객체를 참조한다.");
		//str1주소 == str3주소 : 주소비교 => false
		if(str1 == str3) System.out.println("같은 주소이므로 같은 문자열객체를 참조한다.");
		else System.out.println("다른 주소이므로 다른 문자열객체를 참조한다.");
		
		System.out.println(); 		//구분용 빈줄
		
		/**
		 * 주소를 비교하는 것은 중요하지 않다.
		 * 주소가 참조하는 객체의 값을 비교하는 것이 중요하다.
		 * equals(Object 타입 매개변수) : 두 문자열의 '값을 비교'하여 같으면 true, 다르면 false 리턴
		 * ※ Object 타입 변수 : 모든 클래스 타입의 객체들을 값으로 받아들일 수 있다.
		 * 
		 * equalsIgnoreCase(String 타입 매개변수) : 영어의 대소문자 구분없이 '값을 비교하여' 같으면 true, 다르면 false 리턴
		 */
		
		if(str1.equals(str2)) System.out.println("참조하는 객체 안의 값이 같은 문자열이다.");
		else System.out.println("참조하는 객체 안의 값이 다른 문자열이다.");
		
		if(str1.equals(str3)) System.out.println("참조하는 객체 안의 값이 같은 문자열이다.");
		else System.out.println("참조하는 객체 안의 값이 다른 문자열이다.");
		
		if("AB".equalsIgnoreCase("ab")) System.out.println("대소문자 구분없이 같은 문자열이다.");
		else System.out.println("대소문자 구분없이 다른 문자열이다.");
		
		if("AB".equals("ab")) System.out.println("대소문자 구분하여 같은 문자열이다.");
		else System.out.println("대소문자 구분하여 다른 문자열이다.");
		
		/**
		 * compareTo(String 타입 매개변수) : 두 문자열의 값을 하나씩 비교하여 int(0 또는 0이 아닌 값)를 결과로 돌려줌
		 * compareToIgnoreCase(String 타입 매개변수) : 영어의 대소문자 구분없이 '값을 비교'하여 int(0 또는 0이 아닌 값)를 결과로 돌려줌
		 */
		
		s1 = "AB";	//'65' '66'
		s2 = "AC";	//'65' '67'
		//'65' '66' - '65' '67' => 음수
		
		if(s1.compareTo(s2) == 0) System.out.println("객체 안의 값이 같은 문자열이다.");
		else System.out.println("객체 안의 값이 다른 문자열이다.");//else (s1.compareTo(s2) != 0)
		
		if(s1.compareTo(s2) > 0) System.out.println("뒤의 문자열이 앞선다.");
		else if(s1.compareTo(s2) < 0) System.out.println("앞의 문자열이 앞선다."); 	//else (s1.compareTo(s2) <= 0)
		else System.out.println("두 문자열이 같다.");	//else (s1.compareTo(s2) == 0)
		
		//'97' '99' - '97' => 양수
		if("ac".compareTo("ab") > 0) System.out.println("뒤의 문자열이 앞선다.");
		else if("ac".compareTo("ab") < 0) System.out.println("앞의 문자열이 앞선다."); 	//else ("ac".compareTo("ab") <= 0)
		else System.out.println("두 문자열이 같다.");	//else ("ac".compareTo("ab") == 0)
		
		if("ab".compareToIgnoreCase("AB") != 0) System.out.println("대소문자 구분없이 다른 문자열이다.");
		else System.out.println("대소문자 구분없이 같은 문자열이다.");
		
		System.out.println(); 		//구분용 빈줄
		
		/**
		 * concat() : 두 문자열 연결(=결합)하여 "하나의 새로운 문자열 객체" 생성
		 * 			  catenate
		 */
		s1 = "여러분~";
		//String s = "조금만 더 힘내세요~";
		s1 = s1.concat("조금만 더 힘내세요~");	//"여러분~조금만 더 힘내세요~"
		System.out.println(s1);	//s1이 참조하는 문자열 객체의 값이 출력
		System.out.println(s1.toString());
		
		/**
		 * length() : 문자열의 길이(=문자의 수)
		 * (예)"홍 길 동" 5
		 */
		System.out.println("\"신나는 점심시간!\"의 문자열 길이="+"신나는 점심시간!".length()); 	// 
		
		/**
		 * indexOf() : 찾고자 하는 해당 문자열이 있으면
		 * 			   해당문자열의 시작index번호를 결과로 돌려줌(없으면 -1 리턴)
		 * 			   ★자바에서는 index번호는 0부터 시작
		 * 			   ★SQL에서는 index번호는 1부터 시작 (오라클에서는 instr())
		 */
		int indexNumber = s1.indexOf("조금만");	//4
		System.out.println(indexNumber);
		
		System.out.println(s1.indexOf("최고"));	//-1
		
		if(s1.indexOf("조금만") != -1) {
			System.out.println("해당 문자열이 속해있군요~");
		} else System.out.println("해당 문자열이 없군요~");
		
		/**
		 * replace(기존, 대체) : 다른 문자열로 대체하여 "하나의 새로운 문자열 객체" 생성
		 */
		s2 = s1.replace('~', '!');	//"여러분~조금만 더 힘내세요~"			"여러분!조금만 더 힘내세요!"
		System.out.println(s1);
		System.out.println(s2);
		
		s1 = s1.replace("조금만", "훨씬");
		System.out.println(s1);
		
		System.out.println(); 	//구분용 빈줄
		
		/**
		 * trim() : 앞뒤 공백 제거
		 */
		String tel1="	010";
		String tel2="1234	";
		String tel3="	5678	";
		
		String tel = tel1.trim() + "-" + tel2.trim() + "-" +tel3.trim(); //"010" + "-" +"1234" + "-" + "5678"
		System.out.println(tel1);
		System.out.println(tel2);
		System.out.println(tel3);
		System.out.println(tel);
		
		/**
		 * toLowerCase() : 모두 소문자로, toUpperCase() : 모두 대문자로 변환
		 */
		String str4 = "java";	//"문자열 상수" 객체 생성 '공유상수풀'에 등록
		String str5 = "JAVA";	//"문자열 상수" 객체 생성 '공유상수풀'에 등록
		System.out.println(str4.toUpperCase()); //"JAVA"
		System.out.println(str4);	//"java"
		
		if(str4.equals(str5)) System.out.println("같은 문자열");
		else System.out.println("다른 문자열");
				
		if(str4.equalsIgnoreCase(str5)) System.out.println("대소문자 구분없이 같은 문자열");
		else System.out.println("대소문자 구분없이 다른 문자열");
		
		//if("JAVA".equals(str5))
		if(str4.toUpperCase().equals(str5)) System.out.println("같은 문자열");
		else System.out.println("다른 문자열");
		
		str5 = str5.toLowerCase();	//"java"
		System.out.println(str5); 	//"java"
		
		if(str4.toUpperCase().equalsIgnoreCase(str5)) System.out.println("대소문자 구분없이 같은 문자열");
		else System.out.println("대소문자 구분없이 다른 문자열");
		
		/*************************************************************************
		 * 기본 타입(int, double, char, boolean..)을 "문자열"로 변환하는 방법 - 2가지
		 */
		
		//[방법-1] : valueOf() - 기본타입의 값(value) -> "문자열" 변환하는 String의 static 메서드
		int i = 10;
		String str6 = String.valueOf(i);//10 -> " '1' '0' 	 	 메서드, 필드(=멤버변수)"
		char ch = str6.charAt(0); 	//'1'
		System.out.println("ch=" + ch + ",ch의 코드값=" + (int)ch);
		
		ch = String.valueOf(12.3).charAt(2); 	//12.3 -> " '1' '2' '.' '3' 	메서드, 필드(=멤버변수)"
		System.out.println("ch=" + ch + ",ch의 코드값=" + (int)ch);
				
		ch = "12.3".charAt(2);
		System.out.println("ch=" + ch + ",ch의 코드값=" + (int)ch);
		
		boolean b= true;
		str6 = String.valueOf(b).substring(1); 	//true -> " 't' 'r' 'u' 'e' "	-> " 'r' 'u' 'e' "
		System.out.println("true의 부분 문자열="+str6);
		
		//★자바의 메서드 특징 : 매개변수 2개이고 둘 다 index번호를 가진다면(시작index, 끝index + 1)
		str6 = String.valueOf(b).substring(1, 2+1); 	//true -> " 't' 'r' 'u' 'e' "	-> " 'r' 'u' "
		System.out.println("true의 부분 문자열="+str6);
		
		ch = String.valueOf(b).substring(1).charAt(1); 	// "true" -> 'u'
		System.out.println("true의 부분 문자열="+ ch);	//'u'
		
		//[방법-2] 더 심플 - 두 문자열을 하나로 연결하는 + 이용 : 기본타입의 값(value) -> "문자열" 변환
		int i2 = 10;
		String str7 = i2 + ""; // 10+"" -> "10" + "" => "10"
		str7 = ""+12.3;	//""+"12.3" => "12.3"
		str7 = false+"";	//"false"+"" => "false"
		
		System.out.println(str7.substring(1, 3+1));   // "als"
		System.out.println(str7.charAt(1));	//'a'
		
		/**********************************************************************
		 * "문자열"을 기본타입(int, double, char, boolean..)으로 변환하는 방법 - 2가지
		 * (예)문자열 " '1' '2' '3' "은 연산할 수 없다. 연산을 하려면 기본타입으로 변환
		 * 
		 * 모든 기본타입에는 1:1로 대응하는 Wrapper클래스가 있다.
		 * (예)int:Integer, double:Double, char:Character, boolean:Boolean...
		 */
		//[방법-1] 각 Wrapper클래스의 valueOf() 이용 : "문자열" -> 해당 기본타입의 값으로 변환
		//기본타입 = Wrapper클래스 (자동 언박싱(=auto unboxing)되어 대입됨)
		double d3 = Double.valueOf("12.3"); 	//"12.3" -> 12.3(Double) -> 자동 언박싱12.3
		System.out.println("d3+10="+(d3+10));	//12.3+10=22.3
		
		//"정수나 실수 문자열"에 공백이 있으면 "★자동 공백 제거" 후 기본 타입으로 변환
		d3 = Double.valueOf("	12.3	"); 	//"		12.3	" -> 12.3(Double) -> 자동 언박싱12.3
		System.out.println("d3+10="+(d3+10));	//12.3+10=22.3
				
		int i3 = Integer.valueOf("10");
		System.out.println("i3+12="+(i3+12));
		
		if(Boolean.valueOf("true")) System.out.println("변환됨");
		else System.out.println("변환실패");
		
		//[방법-2] 자주 사용. 각 Wrapper클래스의 parse~()메서드 이용 : "문자열" -> 해본 기본타입의 값으로 변환
		d3 = Double.parseDouble("	12.3	".trim());	//"12.3" -> 12.3
		System.out.println("d3+10="+(d3+10));
		
		//★자동 공백 제거 후 기본타입으로 변환
		d3 = Double.parseDouble("	12.3	");	//"		12.3		" -> "12.3(double)" -> 자동 언박싱12.3
		System.out.println("d3+10="+(d3+10));
				
		i3 = Integer.parseInt("10");
		System.out.println("i3+12="+(i3+12));
		
		if(Boolean.parseBoolean("false")) System.out.println("변환됨");
		else System.out.println("변환실패");
		
		/*
		 * 주의 : Character 클래스에는 "문자열"을 "문자1개"로 변경하는 메서드가 존재하지 않는다.
		 * 이유?문자열을 문자1개로 변환불가
		 * 
		 * ★문자열에서 문자1개로를 추출하여 해결방법 : String의 charAt(index번호) 사용하여 문자1개 추출함
		 *  "abc".charAt(1) -> 'b'추출
		 */
		
		char ch2 = Character.valueOf('a');//사용할 필요 없다.
		System.out.println("ch2="+ch2 + ", ch2의 코드값="+(int)ch2);
		
		ch2 = 'a';
		System.out.println("ch2="+ch2 + ", ch2의 코드값="+(int)ch2);
		
		//ch2 = Character.valueOf("abc"); //컴파일 오류
		//ch2 = Character.parseCharacter("abc");	//parse~메서드 없음
		
		/**
		 * substring() : 문자열에서 원하는 부분만 가져와 "부분 문자열"로 생성
		 * substring(시작index) : '시작index~끝까지' 가져와 "부분 문자열"로 생성
		 * substring(시작index, 목표끝index + 1) : '시작index~목표끝index' 가져와 "부분 문자열"로 생성
		 * 
		 * ★★자바의 메서드 특징 : 매개변수 2개이고 둘 다 index번호를 가진다면(시작index, 목표끝index + 1)
		 */
		String subStr = "행복, 건강, 소망".substring(4);	//"건강, 소망"
		System.out.println(subStr);
		
		//"건강"
		subStr = "행복, 건강, 소망".substring(4, 5+1);	//"건강"
		System.out.println(subStr); //"건강"
		
		/**
		 * split() : 문자열 분리. 즉 "구분자"로 "하나의 문자열"을 "여러 문자열"로 분리
		 */
		String animals="dog, cat, rabbit";
		String[] animalSplit= animals.split(", ");	//"dog" "cat" "rabbit"
		
		System.out.println(animalSplit[0]);	//"dog"
		System.out.println(animalSplit[1]);	//"cat"
		System.out.println(animalSplit[2]);	//"rabbit"
		
		for(int k=0; k <= 2; k++) {
			System.out.println(animalSplit[k]);
		}
		
		/**
		 * 중요	 ... 가변인수 : 여러 매개값들을 "배열"로 처리 (인수=인자=매개값)
		 * join(문자열, 문자열 가변인수) : 여러 문자열 사이에 "구분자"를 넣어서 하나의 문자열로 결합
		 * 			static 메서드 : 클래스이름으로 접근(예)String.join()
		 */
		String animalJoin = String.join("#", animalSplit);	//"dog#cat#rabbit"
		System.out.println("연결된 하나의 문자열=" + animalJoin);
		
		//"DOG#CAT#RABBIT"
		animalJoin = animalJoin.toUpperCase();
		System.out.println("대문자로 변경된 하나의 문자열=" + animalJoin);
		
		/**	"대상문자열" 안에 찾고자 하는 문자열이 있는지 확인하는 방법
		 * 1. "대상문자열".indexOf("찾는문자열") => 찾는 문자열의 시작index번호 리턴받음(없으면 -1리턴받음)
		 * 	  (예)"행복,사랑".indexOf("사랑") ==> 3
		 * 
		 * 2. "대상문자열".contains("찾는문자열") ==> 있으면 true, 없으면 false
		 */
		//[과제-1]
		//[선생님 풀이]
		System.out.println("-------계산기 시작----------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("수 연산자 수 입력>");
		String tmp = sc.next();		//"		1+2		",	"1*2    ",	"   1+2", "	  1/2	"
		tmp = tmp.trim();	//"1+2",   "1-2",     "1*2",   "1/2"
		
		String[] tmpArr = null;
		String opr = null;
		double num1 = 0;		//0 -> 자동형변환 0.0
		double num2 = 0;		//0 -> 자동형변환 0.0
		
		if(tmp.contains("+")) { // if(tmp.indexOf("+") != -1)
			opr = "+";
			//tmpArr = tmp.split("\\+");	//"1"    "2"
			//num1 = Double.parseDouble(tmpArr[0]); //"1" -> 1.0
			//num2 = Double.parseDouble(tmpArr[1]); //"2" -> 2.0
			
		}else if(tmp.contains("-")) {
			opr = "-";
			//tmpArr = tmp.split("-");	//"1"    "2"
			//num1 = Double.parseDouble(tmpArr[0]); //"1" -> 1.0
			//num2 = Double.parseDouble(tmpArr[1]); //"2" -> 2.0
			
		}else if(tmp.contains("*")) {
			opr = "*";
			//tmpArr = tmp.split("\\*");	//"1"    "2"
			//num1 = Double.parseDouble(tmpArr[0]); //"1" -> 1.0
			//num2 = Double.parseDouble(tmpArr[1]); //"2" -> 2.0
			
		}else if(tmp.contains("/")){
			opr = "/";
			//tmpArr = tmp.split("/");	//"1"    "2"
			//num1 = Double.parseDouble(tmpArr[0]); //"1" -> 1.0
			//num2 = Double.parseDouble(tmpArr[1]); //"2" -> 2.0
		}else System.out.println("잘못된 연산자 또는 연산자를 입력하지 않았습니다.");
		
		//* 또는 +는 split 사용할 때 앞에 \\붙여야 함.
		String regex = null;	//구분자로 분리	
		if(opr.equals("+") || opr.equals("*")) {
			regex = "\\" + opr;//		\\+		\\*
		}
		else regex = opr;
		
		tmpArr = tmp.split(regex);	//"1"    "2"
		num1 = Double.parseDouble(tmpArr[0]); //"1" -> 1.0
		num2 = Double.parseDouble(tmpArr[1]); //"2" -> 2.0
		
		switch(opr) {
		case "+":
			System.out.println(tmp = "=" + (num1 + num2));
			break;
		case "-":
			System.out.println(tmp = "=" + (num1 - num2));
			break;
		case "*":
			System.out.println(tmp = "=" + (num1 * num2));
			break;
		case "/":
			System.out.println(tmp = "=" + (num1 / num2));
			break;
		}
		System.out.println("-------계산기 끝----------------------");
		
		/* [본인 풀이]
		String[] tmpSplit = null;
		int first_num = 0;
		int last_num = 0;
		int numResult = 0;
		
		//* 또는 +는 split 사용할 때 앞에 \\붙여야 함.
		if(tmp.contains("+")) {
			tmpSplit = tmp.split("\\+");
			first_num = Integer.parseInt(tmpSplit[0]);		// 첫번째 숫자
			last_num = Integer.parseInt(tmpSplit[1]);		// 두번째 숫자
			numResult = first_num+last_num;					//계산 결과
		}else if(tmp.contains("-")) {
			tmpSplit = tmp.split("-");
			first_num = Integer.parseInt(tmpSplit[0]);		// 첫번째 숫자
			last_num = Integer.parseInt(tmpSplit[1]);		// 두번째 숫자
			numResult = first_num-last_num;					//계산 결과
		}else if(tmp.contains("*")) {
			tmpSplit = tmp.split("\\*");
			first_num = Integer.parseInt(tmpSplit[0]);		// 첫번째 숫자
			last_num = Integer.parseInt(tmpSplit[1]);		// 두번째 숫자
			numResult = first_num*last_num;					//계산 결과
		}else {
			tmpSplit = tmp.split("/");
			first_num = Integer.parseInt(tmpSplit[0]);		// 첫번째 숫자
			last_num = Integer.parseInt(tmpSplit[1]);		// 두번째 숫자
			numResult = first_num/last_num;					//계산 결과
		}
		System.out.println("연산 결과=" + numResult);
		*/
		//과제-1 끝지점
				
		//[과제-2]
		//[문제]주민등록번호를 입력받아 "당신은 yyyy년 mm일 dd일 '2000년 이전/이후'에 태어난 남성/여성입니다."
		boolean flag = true;
		
		while(flag) {
			System.out.print("주민등록번호 입력(예 : 010622-1******) 단, stop 입력 시 멈춤 > ");
			String idNum = sc.next().trim();
			
			if(idNum.equalsIgnoreCase("stop")) {
				flag = false;
				break;//가장 가까운 반복문을 빠져나감
			}
			/*
			if( idNum.charAt(6) != '-') { //if( idNum.indexOf('-') != 6) { //if( !idNum.contains("-") ) {
				System.out.println("잘못 입력하셨습니다. 7번째 자리에 -을 입력해주세요.");
			}
			*/
			//if( idNum.length() != 14 || idNum.charAt(6) != '-') { //[방법-1]
			//if( !(idNum.length() == 14 && idNum.indexOf('-') == 6) ) {//[방법-2]
			if( idNum.length() != 14 || !idNum.contains("-") ) { //[방법-3]주의 : contains()는 -위치와 관계없이 포함되면 true
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;//반복문의 처음으로...
			}
			
			/*------------------------------------------------------------*/
			String[] idNumArr = idNum.split("-");	//index 0 -> "010627", index 1 -> "3234567"
			if(idNumArr[0].length() != 6 || idNumArr[1].length() != 7) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;//반복문의 처음으로...
			}
			
			String year = idNumArr[0].substring(0, 1+1);//"010627" -> "01"
			String month = idNumArr[0].substring(2, 3+1);//"010627" -> "06"
			String day = idNumArr[0].substring(4, 5+1);//"010627" -> "27"
			
			//"3234567"
			char gender = idNumArr[1].charAt(0);
			
			String result = "";
			
			switch(gender) {
			case '1':
			case '3': switch(gender) {
						case '1':
							year = "19" + year; //"1999"
							result += "2000년 이전에 출생한 ";
							break;	//안쪽 switch문 빠져나감
						case '3':
							year = "20" + year;	//"2001"
							result += "2000년 이후에 출생한 ";
							//break;	생략가능
						} // 1-안 switch문 끝
				result += "남성입니다.";
				break;
				
			case '2':
			case '4': switch(gender) {
						case '2':
							year = "19" + year;
							result += "2000년 이전에 출생한 ";
							break;	//안쪽 switch문 빠져나감
						case '4':
							year = "20" + year;
							result += "2000년 이후에 출생한 ";
							//break;	생략가능
						} // 2-안 switch문 끝
				result += "여성입니다.";
				break;
			default:
				result += "잘못된 주민등록번호입니다.";
				//break;		//생략가능
			}//밖 switch문 끝
			
			System.out.println("당신은 " + year + "년 " + month + "월 " + day + "일 " + result);
		}//while문 끝
		
		System.out.println("------주민등록번호 분석 끝------");
		
		/* [본인 풀이]
		System.out.print("주민등록번호 입력(예 : 010622-1234567) > ");
		
		String idNum = sc.next();
		String[] idNumSplit = idNum.split("-");
		
		String idNum_first = idNumSplit[0];		//주민등록번호 앞자리
		String idNum_last = idNumSplit[1];		//주민등록번호 뒷자리

		String birthMonth = idNum_first.substring(2, 3+1);	// 태어난 월
		String birthDay = idNum_first.substring(4, 5+1);	// 태어난 일자
		
		int gender = Integer.parseInt(idNum_last.substring(0, 0+1));		//1, 2 :19YY년 남,녀 - 3, 4 : 20YY년 남,녀
		int birthYear = 0;		//생년(초기화)
		String gender_word = null;
		String yearBef_Aft = null;
		
		switch(gender) {			//주민등록번호 뒷자리 첫 숫자로 판별
			case 1:
				birthYear = Integer.parseInt("19".concat(idNum_first.substring(0, 1+1)));
				gender_word = new String("남성");
				yearBef_Aft = new String("이전");
				break;
			case 2:
				birthYear = Integer.parseInt("19".concat(idNum_first.substring(0, 1+1)));
				gender_word = new String("여성");
				yearBef_Aft = new String("이전");				
				break;
			case 3:
				birthYear = Integer.parseInt("20".concat(idNum_first.substring(0, 1+1)));
				gender_word = new String("남성");
				yearBef_Aft = new String("이후");			
				break;
			case 4:
				birthYear = Integer.parseInt("20".concat(idNum_first.substring(0, 1+1)));
				gender_word = new String("여성");
				yearBef_Aft = new String("이후");			
				break;
			default:
				System.out.println("성별 알 수 없음.");
		}
		
		if (idNum.length() == 14 && 1900 <= birthYear && birthYear <= 2099) {		//입력된 주민등록번호 길이가 '-' 포함 14자리, 생년이 1900년 이상 2099년 이하인 경우
			System.out.println("당신은 " + birthYear + "년 " + birthMonth + "월 " + birthDay + "일 " + "2000년 " + yearBef_Aft + "에 태어난 " + gender_word + "입니다." );
		} else System.out.println("주민등록번호가 올바르지 않습니다.");
		*/
		sc.close();
	}

}
