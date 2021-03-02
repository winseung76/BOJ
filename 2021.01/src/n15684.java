import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15684 {

	static int N, M, H;
	static boolean[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		H = Integer.parseInt(sarr[2]);

		arr = new boolean[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			arr[a][b] = true;
		}

		for (int i = 0; i <= 3; i++) {
			if (solve(0, i))
				break;
		}

		if (min == Integer.MAX_VALUE)
			min = -1;

		bw.write(min + "\n");
		bw.flush();

	}

	public static boolean solve(int cnt, int max) {

		if (cnt == max) {
			if (checkArrive()) {
				min = Math.min(min, max);
				return true;
			}
			return false;
		}

		for (int n = 1; n < N; n++) {
			for (int h = 1; h <= H; h++) {

				if (!arr[h][n]) {
					if (n == 1 && !arr[h][n + 1]) {

						arr[h][n] = true;
						if (solve(cnt + 1, max))
							return true;
						arr[h][n] = false;
					}

					else if ((1 < n && n < N - 1) && !arr[h][n + 1] && !arr[h][n - 1]) {

						arr[h][n] = true;
						if (solve(cnt + 1, max))
							return true;
						arr[h][n] = false;
					}

					else if (n == N - 1 && !arr[h][n - 1]) {

						arr[h][n] = true;
						if (solve(cnt + 1, max))
							return true;
						arr[h][n] = false;
					}
				}
			}
		}
		return false;

	}

	public static boolean checkArrive() {

		// 사다리타기 결과가 어떤지를 확인
		for (int start = 1; start <= N; start++) {

			int n = start;
			int h = 1;

			while (h <= H) {
				if (n < N && arr[h][n])
					n++;
				else if (n > 1 && arr[h][n - 1])
					n--;

				h++;
			}

			if (n != start)
				return false;

		}
		return true;
	}

}
