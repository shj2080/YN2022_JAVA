package tvvcr;

public class TVCRmain {

	public static void main(String[] args) {
		TV tv = new TV();
		tv.power();
		tv.power();
		
		System.out.println("------------------------------------------------");
		
		TVCR tvcr = new TVCR();
		tvcr.power();
		tvcr.power();
		tvcr.power();		
		
		System.out.println("채널 UP 전 : " + tvcr);
		for(int i = 1 ; i<=10 ; i++) {
			tvcr.channelUp();
		}
		System.out.println("채널 UP 후 : " + tvcr);
		
		System.out.println("TV 바코드-1:" + tvcr.getTVBacode());
		System.out.println("TVCR 바코드-1:" + tvcr.getTVCRBacode());
		
		tvcr.setTVBacode(333);
		System.out.println("TV 바코드-1-1:" + tvcr.getTVBacode());
		System.out.println("TVCR 바코드-1-1:" + tvcr.getTVCRBacode());
		
		tvcr.setTVCRBacode(444);
		System.out.println("TV 바코드-1-2:" + tvcr.getTVBacode());
		System.out.println("TVCR 바코드-1-2:" + tvcr.getTVCRBacode());
		
		System.out.println("------------------------------------------------");
		TVCR tvcr2 = new TVCR(222);
		System.out.println(tvcr2);
		System.out.println("TV 바코드-2:" + tvcr2.getTVBacode());
		System.out.println("TVCR 바코드-2:" + tvcr2.getTVCRBacode());
		
		tvcr2.setTVBacode(555);
		System.out.println("TV 바코드-2-1:" + tvcr2.getTVBacode());
		System.out.println("TVCR 바코드-2-1:" + tvcr2.getTVCRBacode());
		
		tvcr2.setTVCRBacode(666);
		System.out.println("TV 바코드-2-2:" + tvcr2.getTVBacode());
		System.out.println("TVCR 바코드-2-2:" + tvcr2.getTVCRBacode());
		
	}

}







