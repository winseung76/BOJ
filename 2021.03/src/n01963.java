import java.io.*;
import java.util.*;

public class n01963 {

	static boolean[] prime = new boolean[10000];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		setPrime();

		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			String A = input[0];
			String B = input[1];

			int res = bfs(A, B, 0);
			if (res == -1)
				bw.write("Impossible\n");
			else
				bw.write(res + "\n");
		}
		bw.flush();
	}

	public static int bfs(String A, String B, int cnt) {

		Queue<Pair> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];

		q.offer(new Pair(A, 0));
		visited[Integer.parseInt(A)] = true;

		while (!q.isEmpty()) {

			Pair p = q.poll();

			if (p.n.equals(B))
				return p.cnt;

			for (int i = 0; i < 4; i++) {
				char ch = p.n.charAt(i);
				int j = 0;
				if (i == 0)
					j = 1;

				for (; j <= 9; j++) {

					if (ch - '0' != j) {
						StringBuffer tmp = new StringBuffer(p.n);
						tmp.replace(i, i + 1, j + "");

						int n = Integer.parseInt(tmp.toString());

						if (prime[n] && !visited[n]) {
							visited[n] = true;
							q.offer(new Pair(tmp.toString(), p.cnt + 1));
						}
					}
				}
			}

		}
		return -1;
	}

	public static void setPrime() {

		for (int i = 0; i < 10000; i++)
			prime[i] = true;

		for (int i = 2; i * i < 10000; i++) {
			if (prime[i]) {
				for (int j = 2; i * j < 10000; j++) {
					prime[i * j] = false;
				}
			}
		}
	}

	static class Pair {

		String n;
		int cnt;

		Pair(String n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}

}
