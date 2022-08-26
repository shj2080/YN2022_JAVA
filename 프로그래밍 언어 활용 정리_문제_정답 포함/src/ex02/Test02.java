package ex02;

public class Test02 {

	public static void main(String[] args) {
		/*
		 * [보기]에서 알맞은 메서드를 선택하여 결과가 나오도록 채우기
		 */
		String s1 = "JAVA";
		
		String s2 = s1.concat("프로그램"); //문자열 연결
		System.out.println(s2); //결과 : JAVA프로그램
		
		//주어진 문자나 문자열의 존재 여부 확인 기능(2가지 중 1가지) - contains, indexOf
		if(s2.contains("JAVA")) {
			System.out.println("JAVA와 관련된 책이군요.");
		}else {
			System.out.println("JAVA와 관련없는 책이군요.");
		}

		if(s2.indexOf("JAVA") != -1) {
			System.out.println("JAVA와 관련된 책이군요.");
		}else {
			System.out.println("JAVA와 관련없는 책이군요.");
		}
		
		//3. "JAVA"를 찾아서 "자바"로 변경
		String s3 = s2.replace("JAVA","자바");
		System.out.println(s3); //결과 : 자바프로그램
		
		//4. "JAVA"대문자를 -> 소문자로 변경 				대문자->소문자 : toLowerCase()  소문자->대문자 : toUpperCase()
		String s4 = s2.toLowerCase();
		System.out.println(s4); //결과 : java프로그램
		
		//5.두 문자열을 대소문자 무시하고 비교	"JAVA프로그램" <-> "java프로그램"     ★★주의 : 문자열 전체를 비교함
		System.out.println(s2.equalsIgnoreCase(s4)); //결과 : true
		
		//6. 하나의 문자열을 구분자로 "분리"하여 만든 여러 문자열을 값으로 가지는 String배열객체 생성 - split()
		String s = "개, 고양이, 토끼";
		String[] arr = s.split(", "); //분리할 구분자 지정 시 공백 주의!
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		//결과 : 개	고양이	토끼	
		System.out.println(); //커서를 아래로
		
		//7. arr의 "개", "고양이", "토끼" 문자열 사이에 구분자("-")를 넣어서 하나의 문자열로 결합
		String s5 = String.join("-", arr);
		System.out.println(s5); //결과 : 개-고양이-토끼
		
	}

}
