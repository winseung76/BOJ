import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class n11779 {

	static int n, m;
	static Vector<Pair>[] arr;
	static int[] dist;
	static int[] preNode;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		arr = new Vector[n + 1];
		dist = new int[n + 1];
		preNode = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			arr[i] = new Vector();
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int w = Integer.parseInt(s[2]);
			arr[a].add(new Pair(b, w));
		}
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);

		bw.write(dijkstra(start, end) + "\n");

		Stack<Integer> stack = new Stack<>();

		int n = end;
		stack.push(end);
		while (true) {
			stack.push(preNode[n]);

			if (preNode[n] == start)
				break;
			
			n = preNode[n];
		}

		bw.write(stack.size() + "\n");
		while (!stack.isEmpty())
			bw.write(stack.pop() + " ");

		bw.flush();

	}

	public static int dijkstra(int s, int e) {

		PriorityQueue<Pair> pq = new PriorityQueue<>();

		dist[s] = 0;
		pq.offer(new Pair(s, dist[s]));

		while (!pq.isEmpty()) {
			Pair pair = pq.poll();

			if (dist[pair.n] < pair.w)
				continue;

			for (Pair p : arr[pair.n]) {
				if (dist[p.n] > dist[pair.n] + p.w) {
					dist[p.n] = dist[pair.n] + p.w;
					preNode[p.n] = pair.n;
					pq.offer(new Pair(p.n, dist[p.n]));
				}
			}
		}
		return dist[e];

	}

	static class Pair implements Comparable<Pair> {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return w - o.w;
		}
	}

}
