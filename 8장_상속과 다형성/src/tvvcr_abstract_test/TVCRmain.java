package tvvcr_abstract_test;

public class TVCRmain {

	public static void main(String[] args) {
		TV tv = new TV(); //자식클래스와 관계없는 tv객체 생성
		tv.power();
		tv.power();	
		
		System.out.println("-----------------");
		TVCR tvcr = new TVCR(); //TV클래스가 부모인 tvcr객체 생성
		tvcr.power();
		tvcr.power();
		tvcr.power();
		
		System.out.println("채널 UP 전 : " + tvcr + "TV 바코드:" + tvcr.getTVBacode());
		for(int i = 1; i <= 10; i++) {
			tvcr.channelUp();
		}
		System.out.println("채널 UP 후 : " + tvcr + "TV 바코드:" + tvcr.getTVBacode());
		
	}

}
