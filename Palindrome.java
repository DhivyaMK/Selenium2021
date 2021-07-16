package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		String name = "Madam";
		String rev = "";
		// converting string in name to characters
		char[] check = name.toCharArray();
		
		//Appending characters of name to rev
		for (int i = check.length-1; i >=0; i--) {
			rev = rev + check[i];

		}
		System.out.println("original value: " + name);
		System.out.println("Reversed Value: " + rev);
		if (name.equalsIgnoreCase(rev))
			System.out.println("Its a Palindrome");
		else
			System.out.println("Its not a Palindrome");
	}

}
