import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class n01753_최단경로 {
	private static int V, E, K;
	private static ArrayList<Pair>[] graph;
	private static int[] dist; // 각 정점의 최단거리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();

		graph = new ArrayList[V];
		dist = new int[V];

		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
			// 시작 정점에서는 0
			if (i == K - 1)
				dist[i] = 0;
			// 그렇지 않은 경우 무한대
			else
				dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt(); // 시작 정점
			int v = sc.nextInt(); // 끝 정점
			int w = sc.nextInt(); // 가중치
			boolean flag = false;

			for (int j = 0; j < graph[u - 1].size(); j++) {
				if (graph[u - 1].get(j).v == v - 1) {
					graph[u - 1].get(j).w = Math.min(w, graph[u - 1].get(j).w);
					flag = true;
					break;
				}
			}
			if (!flag)
				graph[u - 1].add(new Pair(v - 1, w));
		}
		dijkstra(K - 1);

		for (int i = 0; i < V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	public static void dijkstra(int start) {
		PriorityQueue<Pair> q = new PriorityQueue();

		q.offer(new Pair(start, 0));

		while (!q.isEmpty()) {
			int v = q.poll().v;

			for (int i = 0; i < graph[v].size(); i++) {
				Pair p = graph[v].get(i);
				int dst = dist[v] + p.w;

				if (dst < dist[p.v] && p.w > 0) {
					q.offer(p);
					dist[p.v] = dst;
				}
			}

		}
	}

	static class Pair implements Comparable {
		int v, w;

		Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Object o) {
			return w - ((Pair) o).w;
		}
	}
}
