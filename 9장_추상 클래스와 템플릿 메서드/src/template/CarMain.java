package template;

public class CarMain {

	public static void main(String[] args) {
		System.out.println("========  사람이 운전하는 자동차 ================");
		ManualCar mcar = new ManualCar();
		mcar.run();
		
		System.out.println("======== 자율 주행하는 자동차 ================");
		AICar aicar = new AICar();
		aicar.run();
	}

}
