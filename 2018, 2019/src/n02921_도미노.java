import java.util.Scanner;

public class n02921_µµ¹Ì³ë {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= i; j++) {
				sum += (i + j);
			}
		}
		System.out.println(sum);
	}
}
