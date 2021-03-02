import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n01939 {

	static int N, M;
	static Vector<Pair>[] arr;
	static boolean[] visited;
	static int start, end;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");

		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		arr = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new Vector<>();

		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int A = Integer.parseInt(sarr[0]);
			int B = Integer.parseInt(sarr[1]);
			int C = Integer.parseInt(sarr[2]);

			min = Math.min(min, C);
			max = Math.max(max, C);

			arr[A].add(new Pair(B, C));
			arr[B].add(new Pair(A, C));

		}

		sarr = br.readLine().split(" ");
		start = Integer.parseInt(sarr[0]);
		end = Integer.parseInt(sarr[1]);

		int res = binSearch(min, max);

		bw.write(res + "\n");
		bw.flush();
	}

	public static int binSearch(int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (bfs(pc))
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pr;
	}

	public static boolean bfs(int n) {

		visited = new boolean[N + 1];
		Queue<Pair> q = new LinkedList<>();

		visited[start] = true;
		q.offer(new Pair(start, 0));

		while (!q.isEmpty()) {

			Pair p = q.poll();

			if (p.n == end)
				return true;

			for (Pair np : arr[p.n]) {

				if (np.w >= n && !visited[np.n]) {
					visited[np.n] = true;
					q.offer(np);
				}

			}
		}
		return false;

	}

	static class Pair {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

}
