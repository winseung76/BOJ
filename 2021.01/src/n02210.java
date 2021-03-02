import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02210 {

	static int[][] map = new int[5][5];
	static boolean[] check = new boolean[1000000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 5; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(sarr[j]);
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(new Pos(i, j), map[i][j] + "");
			}
		}

		int cnt = 0;
		for (int i = 0; i < check.length; i++) {
			if (check[i])
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void dfs(Pos pos, String s) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };

		if (s.length() == 6) {
			check[Integer.parseInt(s)] = true;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = pos.r + r[i];
			int nc = pos.c + c[i];

			if ((0 <= nr && nr < 5) && (0 <= nc && nc < 5)) {
				dfs(new Pos(nr, nc), s + map[nr][nc]);
			}
		}
	}

	static class Pos {

		int r, c;

		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
