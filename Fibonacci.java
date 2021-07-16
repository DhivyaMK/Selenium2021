package week1.day1;

public class Fibonacci {

	public static void main(String[] args) {
		int i, range = 8, firstNum = 0, secNum = 1, count;
		System.out.println(firstNum);
		for (i = 0; i <= range; i++) {
			count = firstNum + secNum;
			secNum = firstNum;
			firstNum = count;
			System.out.println(count);
		}

	}

}
