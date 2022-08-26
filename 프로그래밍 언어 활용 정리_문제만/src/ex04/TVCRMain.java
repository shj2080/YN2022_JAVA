package ex04;

public class TVCRMain {

	public static void main(String[] args) {
		TV tv=new TV("삼성");
		tv.power(); //1. 출력 결과: TV 전원 ON
		
		VCR vcr=new VCR();		
		vcr.power(); //2. 출력 결과: VCR 전원 ON

		TVCR tvcr=new TVCR("삼성");		
		tvcr.power(); //3. 출력 결과: TVCR 전원 ON
		
		System.out.println("channelUp()메서드 호출 전 채널값 : "+tvcr.channel);
		//4. 출력 결과: channelUp()메서드 호출 전 채널값 : 0
		
		for(int i=1;i<=5;i++) tvcr.channelUp();
				
		System.out.println("channelUp()메서드 호출 후 채널값 : "+tvcr.channel);
		//5. 출력 결과: channelUp()메서드 호출 후 채널값 : 5
		
		tvcr.showTVCR();
		//6. 출력 결과: 만든 나라:한국, 만든 회사:삼성, 전원:true, 현재 채널:5
	}
}

