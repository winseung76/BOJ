import java.util.Scanner;

public class n01748_수이어쓰기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long result = 0;
		String n = String.valueOf(N);

		for (int i = 0; i < n.length() - 1; i++) {
			result += 9 * Math.pow(10, i) * (i + 1);
		}
		result += (N - Math.pow(10, n.length() - 1) + 1) * n.length();
		System.out.println(result);
	}
}
