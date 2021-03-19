import java.io.*;
import java.util.*;

public class n01697 {

	static int N, K;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		for (int i = 0; i <= 100000; i++)
			visited[i] = Integer.MAX_VALUE;

		bw.write(bfs() + "\n");
		bw.flush();
	}

	public static int bfs() {

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(N, 0));
		visited[N] = 0;

		while (!q.isEmpty()) {

			Pair p = q.poll();
			int X = p.n;

			if (X == K)
				return p.time;

			if (X + 1 <= 100000 && p.time < visited[X + 1]) {
				q.offer(new Pair(X + 1, p.time + 1));
				visited[X + 1] = p.time + 1;
			}
			if (0 <= X - 1 && p.time < visited[X - 1]) {
				q.offer(new Pair(X - 1, p.time + 1));
				visited[X - 1] = p.time + 1;
			}
			if (2 * X <= 100000 && p.time < visited[2 * X]) {
				q.offer(new Pair(2 * X, p.time + 1));
				visited[2 * X] = p.time + 1;
			}

		}

		return 0;
	}

	static class Pair {

		int n, time;

		Pair(int n, int time) {
			this.n = n;
			this.time = time;
		}
	}
}
