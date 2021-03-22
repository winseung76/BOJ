import java.io.*;

public class n01987 {

	static int R, C;
	static char[][] arr;
	static boolean[] check = new boolean[26];
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		arr = new char[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			String s = br.readLine();
			for (int j = 1; j <= C; j++) {
				arr[i][j] = s.charAt(j - 1);
			}
		}

		check[arr[1][1] - 'A'] = true;
		solve(1, 1, 1);
		bw.write(max + "\n");
		bw.flush();

	}

	public static void solve(int row, int col, int cnt) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };

		max = Math.max(max, cnt);

		for (int i = 0; i < 4; i++) {
			int nr = row + r[i];
			int nc = col + c[i];

			if ((1 <= nr && nr <= R) && (1 <= nc && nc <= C)) {
				char ch = arr[nr][nc];

				if (!check[ch - 'A']) {
					check[ch - 'A'] = true;
					solve(nr, nc, cnt + 1);
					check[ch - 'A'] = false;
				}
			}

		}

	}

}
