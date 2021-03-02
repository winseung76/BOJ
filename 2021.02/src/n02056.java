import java.io.*;
import java.util.*;

public class n02056 {

	static int N, res;
	static Vector<Integer>[] v;
	static int[] indegree, dp, time;
	static Queue<Integer> order = new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		indegree = new int[N + 1];
		time = new int[N + 1];
		v = new Vector[N + 1];
		for (int i = 1; i <= N; i++)
			v[i] = new Vector<>();

		for (int i = 1; i <= N; i++) {
			String[] sarr = br.readLine().split(" ");

			time[i] = Integer.parseInt(sarr[0]);
			indegree[i] = Integer.parseInt(sarr[1]);
			for (int j = 0; j < indegree[i]; j++) {
				int m = Integer.parseInt(sarr[2 + j]);
				v[m].add(i);
			}
		}

		getOrder();

		while (!order.isEmpty()) {
			int n = order.poll();
			dp[n] += time[n];
			for (int m : v[n])
				dp[m] = Math.max(dp[m], dp[n]);

			res = Math.max(res, dp[n]);
		}

		bw.write(res + "\n");
		bw.flush();

	}

	public static void getOrder() {

		Queue<Integer> q = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			if (indegree[n] == 0)
				q.offer(n);
		}

		while (!q.isEmpty()) {

			int n = q.poll();
			order.offer(n);

			for (int m : v[n]) {
				indegree[m]--;
				if (indegree[m] == 0)
					q.offer(m);
			}
		}
	}
}
