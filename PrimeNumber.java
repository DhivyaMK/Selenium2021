package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		int num = 5;
		int temp;
		temp = num % i;
		if (temp == 0) {
			System.out.println(num + " is not a Prime Number");
		} else {
			System.out.println(num + " is a Prime Number");
		}

	}
}
