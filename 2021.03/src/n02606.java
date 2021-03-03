import java.io.*;
import java.util.*;

public class n02606 {

	static int N;
	static Vector<Integer>[] v;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		v = new Vector[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] sarr = br.readLine().split(" ");
			int a = Integer.parseInt(sarr[0]);
			int b = Integer.parseInt(sarr[1]);

			v[a].add(b);
			v[b].add(a);
		}

		bfs();
		
		for(int i=1;i<=N;i++) {
			bw.write(i+" : ");
			for(int n:v[i])
				bw.write(n+" ");
			bw.write("\n");
		}

		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (visited[i])
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();
	}

	public static void bfs() {

		Queue<Integer> q = new LinkedList<>();

		q.offer(1);
		visited[1] = true;

		while (!q.isEmpty()) {

			int n = q.poll();

			for (int node : v[n]) {
				if (!visited[node]) {
					q.offer(node);
					visited[node] = true;
				}
			}
		}
	}

}
