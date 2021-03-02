import java.io.*;
import java.util.*;

public class n18352 {

	static int N, M, K, X;
	static Vector<Integer>[] v;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);
		K = Integer.parseInt(sarr[2]);
		X = Integer.parseInt(sarr[3]);

		v = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			v[i] = new Vector<>();

		dist = new int[N + 1];
		for (int i = 0; i <= N; i++)
			dist[i] = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			sarr = br.readLine().split(" ");
			int A = Integer.parseInt(sarr[0]);
			int B = Integer.parseInt(sarr[1]);
			v[A].add(B);
		}

		dijkstra();

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K)
				list.add(i);
		}

		if (list.size() == 0)
			bw.write(-1 + "\n");
		else {
			for (int n : list) {
				bw.write(n + "\n");
			}
		}
		bw.flush();
	}

	public static void dijkstra() {

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		dist[X] = 0;
		pq.offer(X);

		while (!pq.isEmpty()) {

			int n = pq.poll();

			for (int m : v[n]) {

				if (dist[m] > dist[n] + 1) {
					dist[m] = dist[n] + 1;
					pq.offer(m);
				}
			}

		}
	}

}
