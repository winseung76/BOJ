import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01937_øÂΩ…¿Ô¿Ã_∆«¥Ÿ {

	static int[][] bamboo, move;
	static int res, n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		bamboo = new int[n][n];
		move = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < n; j++)
				bamboo[i][j] = Integer.parseInt(arr[j]);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (move[i][j] == 0)
					dfs(new Pair(i, j));

				res = Math.max(res, move[i][j]);
			}
		}

		bw.write(res + "\n");
		bw.flush();
	}

	static int dfs(Pair ps) {
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		int cnt = 0;

		move[ps.r][ps.c] = 1;

		for (int k = 0; k < 4; k++) {
			int nr = ps.r + y[k];
			int nc = ps.c + x[k];

			if ((0 <= nr && nr < n) && (0 <= nc && nc < n) && bamboo[nr][nc] > bamboo[ps.r][ps.c]) {

				if (move[nr][nc] > 0)
					cnt = Math.max(cnt, move[nr][nc]);
				else
					cnt = Math.max(cnt, dfs(new Pair(nr, nc)));
			}
		}
		move[ps.r][ps.c] += cnt;

		return move[ps.r][ps.c];
	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
