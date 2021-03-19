import java.io.*;
import java.util.*;

public class n09019 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] input = br.readLine().split(" ");
			String A = input[0];
			String B = input[1];

			String res = bfs(A, B);
			if (res != null)
				bw.write(res + "\n");
		}

		bw.flush();

	}

	public static String bfs(String A, String B) {

		boolean[] visited = new boolean[10000];

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(Integer.parseInt(A), ""));
		visited[Integer.parseInt(A)] = true;

		while (!q.isEmpty()) {

			Pair p = q.poll();

			if (String.valueOf(p.n).equals(B))
				return p.cmd;

			int n = (2 * p.n) % 10000;
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Pair(n, p.cmd + "D"));
			}
			if (p.n == 0)
				n = 9999;
			else
				n = p.n - 1;
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Pair(n, p.cmd + "S"));
			}

			String tmp = String.valueOf(p.n);
			while (tmp.length() < 4)
				tmp = "0" + tmp;
			tmp = tmp.substring(1) + tmp.charAt(0);
			n = Integer.parseInt(tmp);
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Pair(n, p.cmd + "L"));
			}

			tmp = String.valueOf(p.n);
			while (tmp.length() < 4)
				tmp = "0" + tmp;

			tmp = tmp.charAt(tmp.length() - 1) + tmp.substring(0, tmp.length() - 1);
			n = Integer.parseInt(tmp);
			if (!visited[n]) {
				visited[n] = true;
				q.offer(new Pair(n, p.cmd + "R"));
			}
		}

		return null;

	}

	static class Pair {

		int n;
		String cmd;

		Pair(int n, String cmd) {
			this.n = n;
			this.cmd = cmd;
		}
	}

}
