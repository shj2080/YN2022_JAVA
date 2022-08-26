package copyrandom;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayCopyRandomExample {

	public static void main(String[] args) {
		/** 정수형 배열 **/
		int[] a1 = new int[5]; // [0, 0, 0, 0, 0]기본값으로 채워짐
		System.out.println(Arrays.toString(a1));

		// 모두 초기값 2로 변경
		System.out.println("<모두 초기값 2로 변경-1 : for문 사용안함>");
		a1[0] = 2;
		a1[1] = 2;
		a1[2] = 2;
		a1[3] = 2;
		a1[4] = 2;
		System.out.println(Arrays.toString(a1));

		System.out.println("<모두 초기값 5로 변경-2 : for문 사용>");
		int i;
		for (i = 0; i < a1.length; i++) {
			a1[i] = 5;
		}
		System.out.println(Arrays.toString(a1));

		System.out.println("<모두 초기값 7로 변경-3 : Arrays 클래스 사용>");
		Arrays.fill(a1, 7); // a1이 참조하는 배열값을 모두 7(같은값)로 채움
		System.out.println(Arrays.toString(a1));

		// 1~10사이의 정수값을 랜덤으로 채움
		System.out.println("<1~10사이의 정수값을 랜덤으로 채움 : Math 클래스 사용>");
		for (i = 0; i < a1.length; i++) {
			a1[i] = (int) (Math.random() * 10) + 1;
		}
		System.out.println(Arrays.toString(a1));

		/*
		 * 0.0 <= Math.random() < 1.0 실수값 (예:0.000123, 0.1 등) 0.0*10 <= Math.random()*10
		 * < 1.0*10 0.0 <= Math.random()*10 < 10.0 실수값 (예:7.23456, 9.9999) (int)0.0 <=
		 * (int)(Math.random()*10) < (int)10.0 0 <= (int)(Math.random()*10) < 10 (예:0,
		 * 1, 2...9) 0+1 <= (int)(Math.random()*10)+1 < 10+1 (예:1, 2, 3...10)
		 * 
		 * ★ 공식 : (int)(Math.random()*몇개)+시작정수 단, 몇개=끝정수-시작정수+1
		 */

		System.out.println("<11~29사이의 정수값을 랜덤으로 채움 : Math 클래스 사용>");
		for (i = 0; i < a1.length; i++) {
			a1[i] = (int) (Math.random() * (29 - 11 + 1)) + 11;
		}
		System.out.println(Arrays.toString(a1));

		System.out.println("** 문자형 배열 **");
		char[] ch = new char[3]; // ['\0','\0','\0'] 널문자로 채워짐
		System.out.println(Arrays.toString(ch));

		System.out.println("<모두 초기값 'A'로 변경 : Arrays 클래스 사용>");
		Arrays.fill(ch, 'A');
		System.out.println(Arrays.toString(ch));

		System.out.println("<기존 초기값 'A'을 연산하여 'a' 변경 : for문 사용>");
		for (i = 0; i < ch.length; i++) {
			// ch[i] = (char) (ch[i] + 32); //char만 = (char)더한 결과int
			ch[i] += 32;
		}
		System.out.println(Arrays.toString(ch));

		/*****************************************************
		 * 배열 복사 방법 배우는 이유? 배열은 크기가 최초에 한번 정해지면 크기 변경 불가
		 *****************************************************/
		char[] arr = { 'J', 'A', 'V', 'A' }; // arr.length == 4
		System.out.println(" 원본 배열 > " + Arrays.toString(arr));

		System.out.print(" 배열 복사 방법-1 > ");
		// 기존배열보다 2가 큰 배열 생성 ['\0','\0','\0','\0','\0','\0'] 널문자로 채워짐
		char[] arr1 = new char[arr.length + 2];
		/*
		 * arr1[0] = arr[0]; arr1[1] = arr[1]; arr1[2] = arr[2]; arr1[3] = arr[3];
		 */
		for (i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}
		System.out.println(Arrays.toString(arr1)); // [J, A, V, A, '\0', '\0']
		/*
		 * arr1[4] = '~'; arr1[5] = '!';
		 * 
		 * System.out.println(Arrays.toString(arr1)); //[J, A, V, A, ~, !]
		 */
		System.out.print(" 배열 복사 방법-2 > ");
		char[] arr2 = new char[arr.length + 2]; // [널문자('\0')로 채워짐]

		// void arraycopy(원본, 원본의 시작index, 도착지, 도착지의 시작index, 복사할 개수);
		System.arraycopy(arr, 0, arr2, 0, arr.length); // 도착지의 시작index : 0
		System.out.println(Arrays.toString(arr2)); // [J, A, V, A, , ]

		char[] arr2_2 = new char[arr.length + 2];
		System.arraycopy(arr, 0, arr2_2, 2, arr.length);// 도착지의 시작index : 2
		System.out.println(Arrays.toString(arr2_2));

		char[] arr2_3 = new char[arr.length + 2];
		System.arraycopy(arr, 1, arr2_3, 0, arr.length - 2);// 원본의 시작index : 1
		System.out.println(Arrays.toString(arr2_3)); // [A, V, , , ,]

		System.out.print(" 배열 복사 방법-3 > ");
		char[] arr3 = null; // 참조하는 배열객체 없음

		// char[] copyOf(원본, 새 배열객체의 길이)
		arr3 = Arrays.copyOf(arr, arr.length + 2);
		System.out.println(Arrays.toString(arr3));

		System.out.print(" 배열 복사 방법-4(원하는 부분만 복사하여 배열객체 생성/원본배열크기보다 더 큰 배열도 생성됨) > ");
		char[] arr4 = null; // 참조하는 배열객체 없음

		// T : 클래스 타입이 결정되지 않았음. 언제 결정되는가? 객체가 생성될 때 타입이 결정됨
		// T[] Arrays.copyOfRange(T[] 원본, 복사할 시작index, 복사할 끝index+1)

		arr4 = Arrays.copyOfRange(arr, 1, 2 + 1); // [A, V]
		System.out.println(Arrays.toString(arr4));

		arr4 = Arrays.copyOfRange(arr, 0, arr.length + 2); // ['J', 'A', 'V', 'A', '\0','\0']
		System.out.println(Arrays.toString(arr4));

		/**
		 * 7-4 [과제-1] char[] arr = {'J', 'A', 'V' , 'A'};
		 * 
		 * 1. 키보드로 증가할 배열크기(3)를 입력받아 새 배열객체 생성함(기본값으로 채워짐)
		 * ['\0','\0','\0','\0','\0','\0','\0']
		 *
		 * 2. arr이 참조하는 배열의 항목값을 복사하여 새 배열에 대입 ['J', 'A', 'V', 'A','\0','\0','\0']
		 * 
		 * 3. 기본값으로 채워진 곳은 사용자가 입력한 값으로 채움(=>반복문 사용) ['J', 'A', 'V', 'A','~','!','*']
		 */
		
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("--- 7-4 [과제-1] ---");
		int arrayplus;
		char[] arrCopy = null;
		String inputText = null;

		Scanner sc = new Scanner(System.in);

		while (arrCopy == null) { // 배열객체가 할당되지 않은 경우(입력값이 잘못된 경우) 반복
			System.out.println("현재 원본 배열크기=" + arr.length);

			System.out.print("증가시킬 배열 크기(1이상) > ");
			arrayplus = sc.nextInt();

			if (arrayplus < 1) { // 증가할 배열크기가 1미만인 경우
				System.out.println("증가할 배열 크기를 1이상으로 입력하세요.");
				continue; // 잘못된 값이 온 경우 위로 보냄
			}

			arrCopy = new char[arr.length + arrayplus]; // 입력받은 증가할 배열크기만큼 배열 객체 생성
			System.arraycopy(arr, 0, arrCopy, 0, arr.length); // 배열 복사

			System.out.println("요청한 크기만큼 증가한 배열을 생성하여 복사했습니다.");
			System.out.println(Arrays.toString(arrCopy) + "\n");
		}

		while (inputText == null) { // 정상적인 문자를 받지 못한 경우 반복
			System.out.print("복사된 배열의 빈 공간을 채울 문자를 입력 > ");
			inputText = sc.next();

			if (arrCopy.length - arr.length < inputText.length()) { // 복사된 배열의 빈 공간 보다 크다면

				System.out.println("채우려는 문자가 배열의 빈 공간 크기 " + (arrCopy.length - arr.length) + "보다 많습니다.");
				inputText = null; // 재입력 받기 전 초기화
				continue;

			} else if (arrCopy.length - arr.length > inputText.length()) {

				System.out.println("채우려는 문자가 배열의 빈 공간 크기 " + (arrCopy.length - arr.length) + "보다 적습니다.");
				inputText = null; // 재입력 받기 전 초기화
				continue;

			}
		}

		for (i = 0; i < inputText.length(); i++) {
			arrCopy[arr.length + i] = inputText.charAt(i); // 받은 문자열을 char로 변환하여 빈 공간에 대입
		}

		System.out.println("빈 공간 채운 배열 결과=" + Arrays.toString(arrCopy));
		*/
		
		// --------------------------------------------------------------------/
		/*
		 * 0704 [과제-1] 다른 학생 파트
		 */
		System.out.println("--- 방법-1 --------------");
		char value;
		int size = 0;

		System.out.print("새로운 배열의 크기 입력>");
		size = sc.nextInt();
		char[] arr5 = new char[size];
		// 1.size가 원본배열의 크기보다 작으면 부분배열 생성,
		// 2.size가 원본배열의 크기보다 크면 원본보다 큰 배열이 생성되므로 for문에서 입력가능
		arr5 = Arrays.copyOfRange(arr, 0, size);

		System.out.println("arr배열이 대입된 새로운 배열 : " + Arrays.toString(arr5));

		for (i = arr.length; i < arr5.length; i++) { // i = arr.length(중요)
			System.out.print((i + 1) + "번째 공간에 넣을 값을 입력하세요 > ");
			value = sc.next().charAt(0);
			arr5[i] = value;
		}
		System.out.println("완성된 arr5배열은? : " + Arrays.toString(arr5));
		// ----------------------------------------------------------------------/

		System.out.println("--- 방법-2 --------------");

		System.out.print("원본배열보다 증가시킬 배열 크기 입력 > ");
		size = sc.nextInt();

		arr5 = Arrays.copyOf(arr, arr.length + size);

		for (i = arr.length; i < arr5.length; i++) {
			System.out.print("문자 하나씩을 입력해 주세요 > ");// "a" "ab"
			String temp = sc.next();

			if (temp.length() != 1) {
				System.out.println("한 문자만 입력해주세요~^^");
				i--; // ★★
				continue; // ->i++;
			}

			arr5[i] = temp.charAt(0);
		}
		System.out.println("완성된 arr5배열은? : " + Arrays.toString(arr5));
		// --------------------------------------------------------------------/
		System.out.println("--- 방법-3 : 방법-1,2와 다른 점 : charAt(0)사용하지 않고 입력한 문자열 그대로 빈공간에 저장 --------------");
		int arrayplus;
		char[] arrCopy = null;
		String inputText = null;

		while (arrCopy == null) { // 배열객체가 할당되지 않은 경우(입력값이 잘못된 경우) 반복
			System.out.println("현재 원본 배열크기=" + arr.length);

			System.out.print("증가시킬 배열 크기(1이상) > ");
			arrayplus = sc.nextInt();

			if (arrayplus < 1) { // 증가할 배열크기가 1미만인 경우
				System.out.println("증가할 배열 크기를 1이상으로 입력하세요.");
				continue; // 잘못된 값이 온 경우 위로 보냄
			}

			arrCopy = new char[arr.length + arrayplus]; // 입력받은 증가할 배열크기만큼 배열 객체 생성
			System.arraycopy(arr, 0, arrCopy, 0, arr.length); // 배열 복사

			System.out.println("요청한 크기만큼 증가한 배열을 생성하여 복사했습니다.");
			System.out.println(Arrays.toString(arrCopy) + "\n");
		}

		// 입력한 문자열의 크기가 빈 공간에 정확하게 일치하지 않으면 계속 입력받을 수 있도록 처리함
		while (inputText == null) { // 정상적인 문자를 받지 못한 경우 반복
			System.out.print("복사된 배열의 빈 공간을 채울 문자를 입력 > ");
			// 방법-1,2와 다른 점 : charAt(0)사용하지 않고 입력한 문자열 그대로 빈공간에 저장
			inputText = sc.next(); // "abc" -> "ab"

			// 복사배열크기(6)-원본배열크기(4) 입력한 문자열(3)
			if (arrCopy.length - arr.length < inputText.length()) { // 복사된 배열의 빈 공간 보다 크다면

				System.out.println("채우려는 문자가 배열의 빈 공간 크기 " + (arrCopy.length - arr.length) + "보다 많습니다.");
				inputText = null; // 재입력 받기 전 초기화
				continue;

			} else if (arrCopy.length - arr.length > inputText.length()) {

				System.out.println("채우려는 문자가 배열의 빈 공간 크기 " + (arrCopy.length - arr.length) + "보다 적습니다.");
				inputText = null; // 재입력 받기 전 초기화
				continue;

			}
		}

		char[] tmp = inputText.toCharArray();
		System.arraycopy(tmp, 0, arrCopy, arr.length, inputText.length());
		System.out.println("빈 공간 채운 배열 결과=" + Arrays.toString(arrCopy));
		/*
		 * for(i = 0; i < inputText.length(); i++) { arrCopy[arr.length + i] =
		 * inputText.charAt(i); //받은 문자열을 char로 변환하여 빈 공간에 대입 }
		 */

		// -------------------------------------------------------
		System.out.println("--- 방법-4 -------------------");
		System.out.print("증가시킬 배열 크기 입력 > ");
		size = sc.nextInt();

		char[] arr6 = Arrays.copyOf(arr, arr.length + size);
		System.out.println(Arrays.toString(arr6));

		boolean flag = true;
		String input = null;

		while (flag) {
			System.out.print("빈 공간에 추가로 입력할 문자들 한번에 입력> ");
			input = sc.next(); // "abc"
			if (input.length() != size) {
				if (input.length() > size) {
					System.out.println("입력한 문자보다 공간이 " + (input.length() - size) + "만큼 더 부족합니다. 다시 입력해주세요.");
				} else { // input.length() < size
					System.out.println("입력한 문자보다 공간이 " + -(input.length() - size) + "만큼 더 남습니다. 다시 입력해주세요.");
				}
				continue;

			} else {
				flag = false;
				break;
			}
		}

		char[] inputCharArray = input.toCharArray(); // String 객체 -> char형배열로 변환
		System.arraycopy(inputCharArray, 0, arr6, arr.length, input.length()); // input.length()대신 size도 됨.
		System.out.println(Arrays.toString(arr6));
		// -------------------------------------------------------------/

		/*
		 * 7-4 과제 1 키보드로 증가할 배열크기를 입력받아 새 배열 객체 생성함(기본 값으로 채워짐) arr이 참조하는 배열의 항목 값을 복사하여
		 * 새배열에 대입 그리고 기본값으로 채워진 곳은 사용자가 입력한 값으로 채움
		 */

		System.out.println("--- 방법-5 -------------------");
		int plusN;// 증가시킬 값을 넣을 변수
		// 스캔 시작
scanN:  while (true) {// try-catch를 반복시키기 위한 반복문
			try {// input(입력)mismatch(불일치)를 해결하기 위한 try-catch
				while (true) {// 1이상의 정수를 받아들이기 위한 반복문

					System.out.println("증가시킬 배열 크기는?");
					/* 입력하는 값들은 수나 문자다.
					 * 1. 수-정수 : 0보다 큰 정수(O), 0보다 작거나 같은 정수(X) => if문 해결가능,
					 * 		실수(X)=>InputMismatchException예외 생성 => try~catch()문 해결가능
					 * 2. 문자(X)=>InputMismatchException예외 생성 => try~catch()문 해결가능
					 */
					
					plusN = sc.nextInt(); // -1

					if (plusN < 1) {
						System.out.println("1이상의 수를 넣어주세요");
					} else {
						break scanN;// 1이상의 정수이므로 바깥 while문 탈출
					}
				} //안쪽 while문
			} catch (InputMismatchException e) {// 정수가 아닌 실수, 문자 등일 경우
				//sc = new Scanner(System.in);// 스캐너를 초기화 시켜서 잘못 입력된 값을 날림=>버퍼 비움
				sc.nextLine();  //엔터까지 읽어들인 후 엔터를 버리고 나머지 문자들로 문자열 객체 생성=>버퍼 비움
				System.out.println("정수를 입력해주세요");
				//continue; 필요없음 -> 아래쪽에 더 이상 실행할 실행문이 없으므로 바로 반복문의 처음으로 올라가므로...
			}
			//실행할 내용
		}//바깥쪽 while문
		// 새 배열 생성
		arr5 = new char[arr.length + plusN];
		// 배열 복사
		System.arraycopy(arr, 0, arr5, 0, arr.length);

		// 정상적으로 배열이 복사되었는가 확인
		System.out.println("증가된 새 배열 생성 완료");
		System.out.println(Arrays.toString(arr5));

		System.out.println("----------------------------------------------------------");

		// new 배열에 추가할 문자 받아들일 밑준비
		int stopper = arr.length;// while문을 빠져나가기 위한 트리거,배열에 추가할 위치도 겸함
		String temp;// Scanner에서 문자를 받아 들이기 위한 변수
		char addChar;// Scanner에서 받아들인 문자열을 문자형으로 변환후 저장할 변수

		while (stopper < arr5.length) {
			// 전부 문자열로 받아들이기에 try-catch 안함
			System.out.println("추가로 입력하실것이 있으십니까? 없으시다면 no를 입력해주세요 현재 " + (arr5.length - stopper) + "만큼 추가 가능합니다");
			temp = sc.next().trim();

			if (temp.toLowerCase().equals("no")) {	//입력받은 문자열을 소문자로 만든 후 "no"와 비교
				break;// 탈출 조건
			}

			if (temp.length() > 1) { 		//1글자를 초과하는 경우
				System.out.println("1글자가 아닙니다");
			} else { //한 글자를 입력하면
				addChar = temp.charAt(0);
				arr5[stopper] = addChar; //입력하는 시작위치 : arr.length
				stopper++;  //복사된 배열의 문자가 들어갈 index값을 증가
			}
		}
		// 추가된 된 문자열이 정확하게 들어갔나 확인
		System.out.println(Arrays.toString(arr5));

		sc.close();
	}

}
