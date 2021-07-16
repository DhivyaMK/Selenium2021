package week1.day1;

public class ArmstrongNo {

	public static void main(String[] args) {
		int num = 153;
		int calculate = 0, remainder, original;
		original = num;
		while (num > 0) {
			remainder = num % 10;
			num = num/10;
			calculate = calculate + remainder * remainder * remainder;
		}
		if (original == calculate) {
			System.out.println("It is an Armstrong Number");

		}
	}
}
