import java.io.*;
import java.util.*;

public class n04386 {

	static int n;
	static Pos[] pos;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		pos = new Pos[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");
			double x = Double.parseDouble(input[0]);
			double y = Double.parseDouble(input[1]);
			pos[i] = new Pos(x, y);
		}

		bw.write(prim());
		bw.flush();

	}

	public static String prim() {

		double dist = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));

		while (!pq.isEmpty()) {

			Pair p = pq.poll();

			if (visited[p.n])
				continue;

			visited[p.n] = true;
			dist += p.w;

			for (int i = 1; i <= n; i++) {
				if (i != p.n && !visited[i]) {
					double w = Math.sqrt(Math.pow(pos[p.n].x - pos[i].x, 2) + Math.pow(pos[p.n].y - pos[i].y, 2));
					pq.offer(new Pair(i, w));
				}
			}
		}

		return String.format("%.2f", dist);
	}

	static class Pos {

		double x, y;

		Pos(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Pair implements Comparable<Pair> {

		int n;
		double w;

		Pair(int n, double w) {
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(Pair o) {
			return (int) (w - o.w);
		}
	}

}
