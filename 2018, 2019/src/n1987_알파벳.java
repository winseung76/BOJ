import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1987_¾ËÆÄºª {
	private static int R, C;
	private static boolean[] check = new boolean[26];
	private static int[][] board;
	private static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++)
				board[i][j] = s.charAt(j) - 'A';
		}
		int count = dfs(0, 0);

		bw.write(count + "\n");
		bw.flush();

	}

	public static int dfs(int r, int c) {
		int[] x = { 0, 1, 0, -1 };
		int[] y = { 1, 0, -1, 0 };
		int count = 0;
		check[board[r][c]] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + y[i];
			int nc = c + x[i];

			if (0 <= nr && nr < R && 0 <= nc && nc < C && !check[board[nr][nc]]) {
				// count += dfs(nr, nc);
				count = Math.max(dfs(nr, nc), count);
			}
		}
		check[board[r][c]] = false;

		return count + 1;
	}
}
