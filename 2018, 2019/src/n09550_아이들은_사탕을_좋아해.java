import java.util.Scanner;

public class n09550_아이들은_사탕을_좋아해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int count = 0;
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			count = 0;
			for (int j = 0; j < N; j++) {
				int x = sc.nextInt();
				count += x / K;
			}
			System.out.println(count);
		}
	}
}
