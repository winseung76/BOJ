import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class n11559_Puyo_Puyo {

	static char[][] field = new char[12][6];
	static boolean[][] visited = new boolean[12][6];
	static List<Pair> lst = new ArrayList<>();
	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 12; i++) {
			String[] arr = br.readLine().split("");
			for (int j = 0; j < 6; j++)
				field[i][j] = arr[j].charAt(0);
		}
		while (true) {
			visited = new boolean[12][6];
			boolean flag = false;
			

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					lst.clear();
					if (!visited[i][j] && field[i][j] != '.') {
						boolean result = dfs(i, j);
						if (!flag && result)
							flag = true;

					}
				}
			}
			if (!flag) {
				bw.write(res + "\n");
				bw.flush();
				return;
			}
			res++;
			setField(); // 중력에 의한 필드 재설정
		}

	}

	public static boolean dfs(int r, int c) {
		Stack<Pair> s = new Stack<>();
		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		int cnt = 1;

		s.push(new Pair(r, c));
		visited[r][c] = true;

		while (!s.isEmpty()) {

			Pair p = s.peek();

			boolean flag = false;

			for (int i = 0; i < 4; i++) {
				int nr = p.r + y[i];
				int nc = p.c + x[i];

				if ((0 <= nr && nr < 12) && (0 <= nc && nc < 6) && !visited[nr][nc]
						&& field[nr][nc] == field[r][c]) {
					cnt++;
					s.push(new Pair(nr, nc));
					visited[nr][nc] = true;
					flag = true;
					break;
				}

			}
			if (!flag)
				lst.add(s.pop());

		}
		if (cnt >= 4) {
			Iterator<Pair> it = lst.iterator();
			while (it.hasNext()) {
				Pair p = it.next();
				field[p.r][p.c] = '.';
			}

			return true;
		}
		return false;
	}

	public static void setField() {
	
		for (int k = 11; k >= 0; k--) {
			for (int i = 0; i < 6; i++) {
				for (int j = 11; j >= 0; j--) {
					
					if (field[j][i] == '.') {
						if (j - 1 >= 0) {
							field[j][i] = field[j - 1][i];
							field[j - 1][i] = '.';
						} else
							field[j][i] = '.';

					}

				}
			}
		}
	}

	static class Pair {
		int r, c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
