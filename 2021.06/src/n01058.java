import java.io.*;
import java.util.*;

public class n01058 {

	static int N;
	static ArrayList<Integer>[] w;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		w = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			w[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = str.charAt(j);

				if (ch == 'Y') {
					w[i].add(j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			int cnt = bfs(i);
			max = Math.max(max, cnt);
		}

		bw.write(max + "\n");
		bw.flush();
	}

	public static int bfs(int s) {

		boolean[] visited = new boolean[N];
		Queue<Pair> q = new LinkedList<>();
		int cnt = 0;

		q.offer(new Pair(s, 0));
		visited[s] = true;

		while (!q.isEmpty()) {

			Pair pair = q.poll();

			if (pair.cnt >= 2)
				continue;

			for (int m : w[pair.n]) {
				if (!visited[m]) {
					q.offer(new Pair(m, pair.cnt + 1));
					visited[m] = true;
					cnt++;
				}
			}
		}

		return cnt;

	}

	static class Pair {

		int cnt, n;

		Pair(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

}
