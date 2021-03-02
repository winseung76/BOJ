import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n01916_최소비용구하기 {
	private static ArrayList<Pair>[] weight;
	private static int[] dist;
	private static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		weight = new ArrayList[N];
		dist = new int[N];

		for (int i = 0; i < N; i++)
			weight[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			weight[s - 1].add(new Pair(e - 1, w));

		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			if (i == start - 1)
				dist[i] = 0;
			else
				dist[i] = Integer.MAX_VALUE;
		}

		dijkstra(start - 1, end - 1);

	}

	public static void dijkstra(int start, int end) {
		Queue<Integer> q = new LinkedList();

		q.offer(start);

		while (!q.isEmpty()) {
			int v = q.poll();

			for (int i = 0; i < weight[v].size(); i++) {
				Pair p = weight[v].get(i);
				int nd = dist[v] + p.w;
				if (nd < dist[p.v]) {
					dist[p.v] = nd;
					q.offer(p.v);
				}
			}

		}
		System.out.println(dist[end]);

	}

	static class Pair {
		int v, w;

		Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}
