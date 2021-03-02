import java.io.*;
import java.util.Arrays;

public class n17779 {

	static int N;
	static int[][] A, partition;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(sarr[j - 1]);
			}
		}

		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N - 2; d1++) {
					for (int d2 = 1; d2 <= N - 2; d2++) {
						partition = new int[N + 1][N + 1];

						if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {
							solve(x, y, d1, d2);
						}
					}
				}
			}
		}

		bw.write(min + "\n");
		bw.flush();

	}

	public static void solve(int X, int Y, int d1, int d2) {

		int[] sum = new int[6];

		int sy = Y;
		int ey = Y;
		int cnt1 = d1;
		int cnt2 = d2;
		for (int x = X; x <= X + d1 + d2; x++) {
			for (int y = sy; y <= ey; y++) {
				sum[5] += A[x][y];
				partition[x][y] = 5;
			}

			if (cnt1 > 0) {
				sy--;
				cnt1--;
			} else
				sy++;

			if (cnt2 > 0) {
				ey++;
				cnt2--;
			} else
				ey--;
		}

		for (int r = 1; r < X + d1; r++) {
			for (int c = 1; c <= Y; c++) {
				if (partition[r][c] != 5) {
					sum[1] += A[r][c];
					partition[r][c] = 1;
				}
			}
		}

		for (int r = 1; r <= X + d2; r++) {
			for (int c = Y + 1; c <= N; c++) {
				if (partition[r][c] != 5) {
					sum[2] += A[r][c];
					partition[r][c] = 2;
				}
			}
		}

		for (int r = X + d1; r <= N; r++) {
			for (int c = 1; c < Y - d1 + d2; c++) {
				if (partition[r][c] != 5) {
					sum[3] += A[r][c];
					partition[r][c] = 3;
				}
			}
		}

		for (int r = X + d2 + 1; r <= N; r++) {
			for (int c = Y - d1 + d2; c <= N; c++) {
				if (partition[r][c] != 5) {
					sum[4] += A[r][c];
					partition[r][c] = 4;
				}
			}
		}

		Arrays.sort(sum);
		min = Math.min(min, sum[5] - sum[1]);

	}

}
