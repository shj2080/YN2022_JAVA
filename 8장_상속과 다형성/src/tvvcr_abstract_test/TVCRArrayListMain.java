package tvvcr_abstract_test;

import java.util.ArrayList;

public class TVCRArrayListMain {

	public static void main(String[] args) {
		/**
		 * ArrayList는 <Electronics>를 관리함
		 * (Electronics객체 또는 Electronics의 자식객체만 관리)
		 * ※ Electronics는 추상클래스이므로 객체 생성 불가!
		 */
		ArrayList<Electronics> eList = new ArrayList<Electronics>();
		//new Electronics();//오류-추상클래스 객체 생성 불가
		
		//Electronics의 자식객체를 ArrayList에 추가 (UpCasting 발생)
		eList.add(new TV());
		eList.add(new VCR());
		eList.add(new TVCR());
		
		System.out.println("============ 각 전자제품의 정보 한꺼번에 출력 ================");
		/*
		 * ArrayList클래스에서 toString()를 재정의함
		 * [TV객체주소, VCR객체주소, TVCR객체주소]
		 * =[TV객체주소.toString(), VCR객체주소.toString(), TVCR객체주소.toString()]
		 */
		System.out.println(eList);
		System.out.println(eList.toString());
		System.out.println(); //구분용 빈줄
		
		System.out.println("============ 각 전자제품의 정보 각각 출력 ================");
		System.out.println("-------------[1.for문]-------------------------");
		int i;
		for(i = 0; i < eList.size(); i++) {
			System.out.println(eList.get(i));
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("-------------[2.향상된 for문]-------------------------");
		for(Electronics e:eList) {	//eList안에는 모두 Electronics형으로 UpCasting 되어 있으므로
			System.out.println(e);
		}
		System.out.println(); //구분용 빈줄
		
		System.out.println("============ 각 전자제품의 메서드 호출 후 정보 출력 ================");
		for(Electronics e:eList) {
			e.power(); //Electronics에 정의된 메서드만 호출(이 때, 재정의된 메서드 호출)
			
			
			//TVCR tvcr2 = (TVCR) e;		//아무 자식으로 강제 형변환해도 컴파일오류가 안남(문제점)
			//그러나 실행시 java.lang.ClassCastException예외객체 생성 -> 프로그램 강제 종료
			//따라서 instanceOf를 이용하여 어떤 자식인지 확인 후 자식클래스로 형변환함
			
			//String s = (String) e; 	//그러나 자식이 아닌 클래스로 강제 형변환하면 컴파일오류 발생함
			
			//★★ 자식 클래스에 추가된 메서드 호출하기 위해 아래 코드 작성함
			//e가 참조하는 객체가 TVCR객체 또는 TVCR자식객체이면 true
			if(e instanceof TVCR) {//가장 마지막 자식부터
				
				/*
				((TVCR) e).play();
				((TVCR) e).fast_forward();
				((TVCR) e).rewind();
				((TVCR) e).stop();
				*/
				
				TVCR tvcr = (TVCR) e;			//Electronics -> 자식클래스 TVCR형으로 강제 형변환(DownCasting)
				tvcr.play();
				tvcr.fast_forward();
				tvcr.rewind();
				tvcr.stop();
				
			}else if(e instanceof TV) {
				TV tv = (TV)e;					//Electronics -> 자식클래스 TV형으로 강제 형변환(DownCasting)
				for(i = 1; i <= 5; i++) {
					//((TV) e).channelUp();
					tv.channelUp();
				}			
			}else if(e instanceof VCR) {
				VCR vcr = (VCR)e;				//Electronics -> 자식클래스 VCR형으로 강제 형변환(DownCasting)		
				vcr.play();
				vcr.stop();
				vcr.rewind();
				vcr.fast_forward();
				
				vcr.capture(); //캡쳐까지 가능함
			}
			
			System.out.println(e.toString()); //각 클래스의 재정의된 toString()메서드 호출됨
			System.out.println("-----------------------------------------");
			
		} //for문 끝
		
	}

}
