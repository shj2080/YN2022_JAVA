package forwhiledowhile;

public class BreakTest {

	public static void main(String[] args) {
		/**
		 * [문제] 1부터 계속 1씩 증가하는 수를 더하다가 '100을 초과'하는 최초의 정수값을 알아보기
		 */
		int i, hap = 0;
		for(i = 1; true ; ) { 	//i = 1 2 3...14
			//i++; 	//결과X=>위에 있으면 원하는 i의 결과보다 1 증가됨
			
			hap += i; 	//1+2+...14
			if(hap > 100) break;
			
			i++;
		}
		System.out.println("[for문]" + i + "," + hap);
	
		i = 1; hap = 0;
		while(true) { 	//i = 1 2 3...14
			hap += i; 	//1+2+...14
			if(hap > 100) break;
			i++;
		}
		System.out.println("[while문]" + i + "," + hap);
		
		i = 1; hap = 0;
		do { 	//i = 1 2 3...14
			hap += i; 	//1+2+...14
			if(hap > 100) break;
			i++;
		} while(true);
		System.out.println("[do~while문]" + i + "," + hap);
		
		System.out.println("-----------------------------------------");
		System.out.println("i초기값을 0으로 변경, i++위치 반복문 안에서 위로 이동함");
		i = 0; hap = 0;
		for( ; true ; ) { 	//i = 0 1 2 3...14
			i++; 	//위에 있어도 결과OK
			
			//if(hap > 100) break;  //결과X(이유?i가 15된 상태에서 반복문 멈춤)
			hap += i; 	//0+1+2+...14
			if(hap > 100) break;
			//i++; //결과OK
		}
		System.out.println("[for문]" + i + "," + hap);
		
		i = 0; hap = 0;
		while(true) { 	//i = 0 1 2 3...14
			i++;
			
			hap += i; 	//1+2+...14
			if(hap > 100) break;
			
			//i++;   //결과OK
		}
		System.out.println("[while문]" + i + "," + hap);
		
		i = 0; hap = 0;
		do { 	//i = 0 1 2 3...14
			i++;
			
			hap += i; 	//0+1+2+...14
			if(hap > 100) break;
			
			//i++;  //결과OK
		} while(true);
		System.out.println("[do~while문]" + i + "," + hap);
	}

}
