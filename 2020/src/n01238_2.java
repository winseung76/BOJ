
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n01238_2 {

	static int N, M, X;

	static List<Pair>[] arr;
	static boolean[] check;
	static int[] dist;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		X = Integer.parseInt(s[2]);

		arr = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int w = Integer.parseInt(s[2]);

			arr[a].add(new Pair(b, w));
		}

		int max = 0;
		for (int i = 1; i <= N; i++)
			max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));

		bw.write(max + "\n");
		bw.flush();

	}

	public static int dijkstra(int s, int e) {

		check = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, 0, N + 1, Integer.MAX_VALUE);

		dist[s] = 0;

		for (int i = 0; i < N; i++) {

			int min = Integer.MAX_VALUE;
			int index = 0;

			for (int j = 1; j <= N; j++) {
				if (!check[j] && min > dist[j]) {
					min = dist[j];
					index = j;
				}
			}
			check[index] = true;

			for (int j = 0; j < arr[index].size(); j++) {
				Pair p = arr[index].get(j);

				dist[p.n] = Math.min(dist[p.n], dist[index] + p.w);
			}
		}

		return dist[e];
	}

	static class Pair {

		int n;
		int w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

}
