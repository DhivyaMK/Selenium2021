package week1.day2;

public class MyMobile {
	int screenSize = 12;
	int cost = 50000;
	char logo = 's';
	float amp = 1.5f;
	long mobileNumber = 6745236798l;
	boolean istouch = true;
	String brand = "Galaxy";

//Methods
	public void makeCall() {
		System.out.println("Call Dhivya");

	}

	public void sendMsg() {
		System.out.println("Send Message");
	}

	private void payBill() {
		System.out.println("Pay Mobile Bill");
	}

	public static void main(String[] args) {
		// creating object

		MyMobile mobObj = new MyMobile();

		// access methods using objects

		mobObj.makeCall();
		mobObj.sendMsg();
		mobObj.payBill();

	}

}
