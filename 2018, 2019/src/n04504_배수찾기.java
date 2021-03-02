import java.util.Scanner;

public class n04504_배수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x;
		while ((x = sc.nextInt()) != 0) {
			if (x % n == 0)
				System.out.println(x + " is a multiple of " + n + ".");
			else if (x % n != 0)
				System.out.println(x + " is NOT a multiple of " + n + ".");
		}
	}
}
