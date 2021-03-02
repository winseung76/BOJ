import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 방문한 곳을 또 방문해야할 필요가 있는 문제 -> visited배열이 의미가 없다?
// 그렇다면 visited배열을 사용하지 않으면서 무한루프를 막을 수 있는가?
public class n01525 {

	static int[][] map = new int[3][3];
	static HashSet<String> set = new HashSet<>();
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuffer buf = new StringBuffer();
		int sr = 0;
		int sc = 0;
		for (int i = 0; i < 3; i++) {
			String[] sarr = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(sarr[j]);
				buf.append(map[i][j] + "");
				if (map[i][j] == 0) {
					sr = i;
					sc = j;
				}
			}
		}

		Pos start = new Pos(sr, sc, 0, buf.toString());

		bw.write(bfs(start) + "\n");
		bw.flush();

	}

	public static int bfs(Pos start) {

		int[] r = { 0, 1, 0, -1 };
		int[] c = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();

		q.offer(start);
		set.add(start.str);

		while (!q.isEmpty()) {

			Pos pos = q.poll();

			if (pos.str.equals("123456780"))
				return pos.cnt;

			for (int i = 0; i < 4; i++) {
				int nr = pos.r + r[i];
				int nc = pos.c + c[i];

				if ((0 <= nr && nr < 3) && (0 <= nc && nc < 3)) {

					char num1 = pos.str.charAt(pos.r * 3 + pos.c);
					char num2 = pos.str.charAt(nr * 3 + nc);

					StringBuffer buf = new StringBuffer();
					buf.append(pos.str);
					buf.setCharAt(pos.r * 3 + pos.c, num2);
					buf.setCharAt(nr * 3 + nc, num1);

					String s = buf.toString();

					if (!set.contains(s)) {
						q.offer(new Pos(nr, nc, pos.cnt + 1, s));
						set.add(s);
					}

				}
			}
		}
		return -1;

	}

	static class Pos {

		int r, c, cnt;
		String str;

		Pos(int r, int c, int cnt, String str) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.str = str;
		}
	}

}
