import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01389_케빈_베이컨의_6단계_법칙 {
	private static int[][] graph;
	private static boolean[] isvisited;
	private static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		graph = new int[100][100];

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]) - 1;
			int b = Integer.parseInt(s[1]) - 1;
			graph[a][b] = graph[b][a] = 1;
		}

		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < N; i++) {
			isvisited = new boolean[N];
			int n = bfs(i);
			if (n < min) {
				min = n;
				result = i;
			}
		}
		bw.write((result + 1) + "\n");
		bw.flush();

	}

	public static int bfs(int start) {

		Queue<Pair> q = new LinkedList<>();
		int sum = 0;

		q.add(new Pair(start, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();
			sum += p.count;

			for (int i = 0; i < 100; i++) {
				if (graph[p.n][i] == 1 && !isvisited[i]) {
					q.add(new Pair(i, p.count + 1));
					isvisited[i] = true;
				}
			}
		}

		return sum;
	}

	static class Pair {
		int n, count;

		Pair(int n, int count) {
			this.n = n;
			this.count = count;
		}
	}
}
