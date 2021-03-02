import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n14226 {

	static int S;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = Integer.parseInt(br.readLine());

		visited = new boolean[1001][1001];

		solve();
		bw.write(min + "\n");
		bw.flush();

	}

	public static void solve() {

		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(1, 0, 0));

		while (!q.isEmpty()) {

			Pair p = q.poll();

			if (p.n == S) {
				min = Math.min(min, p.cnt);
				return;
			}

			if (!visited[p.n][p.n]) {
				visited[p.n][p.n] = true;
				q.offer(new Pair(p.n, p.n, p.cnt + 1));
			}
			if (p.n + p.clip <= 1000 && !visited[p.n + p.clip][p.clip]) {
				visited[p.n + p.clip][p.clip] = true;
				q.offer(new Pair(p.n + p.clip, p.clip, p.cnt + 1));
			}
			if (0 < p.n - 1 && !visited[p.n - 1][p.clip]) {
				visited[p.n - 1][p.clip] = true;
				q.offer(new Pair(p.n - 1, p.clip, p.cnt + 1));
			}
		}
	}

	static class Pair {

		int n, clip, cnt;

		Pair(int n, int clip, int cnt) {
			this.n = n;
			this.clip = clip;
			this.cnt = cnt;
		}
	}
}
