import java.util.Scanner;

public class n01094_¸·´ë±â {
	public static void main(String[] args) {
		int n = new Scanner(System.in).nextInt();

		int count = 0;
		while (n > 0) {
			if (n % 2 == 1)
				count++;
			n = n / 2;
		}
		System.out.println(count);
	}
}
