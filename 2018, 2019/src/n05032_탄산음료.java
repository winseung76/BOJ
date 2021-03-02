import java.util.Scanner;

public class n05032_Åº»êÀ½·á {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();
		int sum = e + f;
		int result = 0;

		while (sum >= c) {
			result += sum / c;
			sum = sum / c + sum % c;
		}

		System.out.println(result);
	}
}
