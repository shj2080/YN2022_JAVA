package ex05;

//예외 처리 문제
public class MyException { //문자열을 정수로 변환하는 클래스

	public static void main(String[] args) {
		String[] arr = {"12","37","1.23","99"};
		
		//for문 조건식, 정수변환메서드 찾기
		for(int i = 0; i < arr.length; i++) {
			try {
				int num = Integer.parseInt(arr[i]);	//문자열->정수(예외발생)
				System.out.println("정수로 변환된 값은 " + num);
			} catch (NumberFormatException e) {//잡아서
				//e.printStackTrace();
				System.out.println(arr[i] + "은(는) 정수로 변환할 수 없습니다."); //처리
			}
		}
	}
 
}
