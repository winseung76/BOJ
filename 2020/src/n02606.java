import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n02606 {

	static int N, M;
	static Vector<Integer>[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new Vector[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new Vector();

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			arr[a].add(b);
			arr[b].add(a);
		}
		bw.write(bfs(1) + "\n");
		bw.flush();

	}

	public static int bfs(int s) {

		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();

		q.offer(s);
		visited[s] = true;

		while (!q.isEmpty()) {

			int n = q.poll();

			for (int i = 0; i < arr[n].size(); i++) {
				int m = arr[n].get(i);
				if (!visited[m]) {
					q.offer(m);
					visited[m] = true;
					cnt++;

				}
			}

		}
		return cnt;
	}

}
