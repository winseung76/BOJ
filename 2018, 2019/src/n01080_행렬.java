import java.util.Scanner;

public class n01080_За·Д {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		boolean[][] C = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++)
				A[i][j] = s.charAt(j) - '0';
		}
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < M; j++)
				B[i][j] = s.charAt(j) - '0';
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] == B[i][j])
					C[i][j] = true;
			}
		}

		int[] x = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
		int[] y = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };

		int min_count = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (!C[i][j]) {
					for (int k = 0; k < 9; k++) {
						C[i + y[k]][j + x[k]] = !C[i + y[k]][j + x[k]];
					}
					min_count++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!C[i][j])
					count++;
			}
		}
		if (count > 0)
			System.out.println(-1);
		else
			System.out.println(min_count);

	}
}
