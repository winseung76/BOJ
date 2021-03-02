import java.util.Scanner;

public class n02167_2차원_배열의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		int res = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		int K = sc.nextInt();

		for (int k = 0; k < K; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			res = 0;

			for (int r = i - 1; r < x; r++) {
				for (int c = j - 1; c < y; c++) {
					res += arr[r][c];
				}
			}
			System.out.println(res);

		}

	}
}
