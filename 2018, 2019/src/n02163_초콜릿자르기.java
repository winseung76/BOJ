import java.util.Scanner;

public class n02163_초콜릿자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		System.out.println(N - 1 + N * (M - 1));
	}
}
