import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class n01697_¼û¹Ù²ÀÁú {
	private static int K;
	private static int result = -1;
	private static boolean[] isvisited = new boolean[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int N = Integer.parseInt(s.split(" ")[0]);
		K = Integer.parseInt(s.split(" ")[1]);

		bfs(N);

		bw.write(result + "\n");
		bw.flush();

	}

	public static void bfs(int N) {

		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(N, 0));
		isvisited[N] = true;

		while (!q.isEmpty()) {
			Pair pair = q.poll();
			int X = pair.n;

			if (X == K) {
				if (result < 0)
					result = pair.count;
				return;
			}

			if (X - 1 >= 0 && !isvisited[X - 1]) {
				q.offer(new Pair(X - 1, pair.count + 1));
				isvisited[X - 1] = true;
			}
			if (X + 1 <= 100000 && !isvisited[X + 1]) {
				q.offer(new Pair(X + 1, pair.count + 1));
				isvisited[X + 1] = true;
			}
			if (X * 2 <= 100000 && !isvisited[X * 2]) {
				q.offer(new Pair(X * 2, pair.count + 1));
				isvisited[X * 2] = true;
			}
		}
	}

	static class Pair {
		int n, count;

		Pair(int n, int count) {
			this.n = n;
			this.count = count;
		}
	}
}
