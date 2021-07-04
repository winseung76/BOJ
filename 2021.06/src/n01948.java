import java.io.*;
import java.util.*;

public class n01948 {

	static int n, m, start, end;
	static int[] indegree, time, count;
	static List<Pair>[] arr;
	static List<List<Integer>>[] road;
	static boolean[][] check;
	static int nodeCnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		indegree = new int[n + 1];
		time = new int[n + 1];
		count = new int[n + 1];
		arr = new ArrayList[n + 1];
		road = new ArrayList[n + 1];
		check = new boolean[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			arr[i] = new ArrayList<>();
			road[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);

			arr[s].add(new Pair(e, w));
			indegree[e]++;
		}

		String[] input = br.readLine().split(" ");
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);

		solve();

		for (int i = 0; i < road[end].size(); i++) {
			List<Integer> list = road[end].get(i);

			for (int j = 0; j < list.size() - 1; j++) {
				check[list.get(j)][list.get(j + 1)] = true;
				System.out.print(list.get(j) + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (check[i][j])
					nodeCnt++;
			}
		}

		bw.write(time[end] + "\n");
		bw.write(nodeCnt + "\n");
		bw.flush();

	}

	public static void solve() {

		Queue<Pair2> q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				q.offer(new Pair2(i, list));
			}
		}

		while (!q.isEmpty()) {

			Pair2 p = q.poll();

			// System.out.println(n + " " + count[n]);

			for (Pair np : arr[p.n]) {

				indegree[np.n]--;
				List<Integer> tmp = new ArrayList<>(p.list);
				tmp.add(np.n);

				if (time[p.n] + np.w > time[np.n]) {
					time[np.n] = time[p.n] + np.w;
					road[np.n].clear();
					road[np.n].add(tmp);
				}

				else if (time[p.n] + np.w == time[np.n]) {
					road[np.n].add(tmp);
				}

				if (indegree[np.n] == 0) {
					q.offer(new Pair2(np.n, tmp));
				}
			}

		}
	}

	static class Pair {

		int n, w;

		Pair(int n, int w) {
			this.n = n;
			this.w = w;
		}
	}

	static class Pair2 {

		int n;
		List<Integer> list;

		Pair2(int n, List<Integer> list) {
			this.n = n;
			this.list = list;
		}
	}

}
