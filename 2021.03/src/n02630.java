import java.io.*;

public class n02630 {

	static int N;
	static int[][] arr;
	static int white, blue;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(sarr[j]);
			}
		}
		solve(0, 0, N);

		bw.write(white + "\n");
		bw.write(blue + "\n");
		bw.flush();
	}

	public static void solve(int r, int c, int size) {

		if (size == 1) {
			if (arr[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}

		boolean flag = true;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != arr[r][c]) {
					flag = false;
					break;
				}
			}
			if (!flag)
				break;
		}

		if (flag) {
			if (arr[r][c] == 0)
				white++;
			else
				blue++;
			return;
		}

		for (int i = r; i < r + size; i += size / 2) {
			for (int j = c; j < c + size; j += size / 2) {
				solve(i, j, size / 2);
			}
		}
	}

}
