import java.util.Scanner;

public class n02010_ÇÃ·¯±× {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (i > 0)
				count--;
			count += sc.nextInt();
		}
		System.out.println(count);
	}
}
