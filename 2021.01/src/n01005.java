import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n01005 {

	static int N, K;
	static int[] D;
	static Vector<Integer>[] arr;
	static int[] indegree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			String[] sarr = br.readLine().split(" ");
			N = Integer.parseInt(sarr[0]);
			K = Integer.parseInt(sarr[1]);

			arr = new Vector[N + 1];
			for (int i = 0; i <= N; i++)
				arr[i] = new Vector<>();

			indegree = new int[N + 1];
			D = new int[N + 1];

			sarr = br.readLine().split(" ");
			for (int i = 1; i <= N; i++)
				D[i] = Integer.parseInt(sarr[i - 1]);

			for (int i = 0; i < K; i++) {
				sarr = br.readLine().split(" ");
				int X = Integer.parseInt(sarr[0]);
				int Y = Integer.parseInt(sarr[1]);
				arr[X].add(Y);
				indegree[Y]++;
			}

			int W = Integer.parseInt(br.readLine());
			long res = getMinTime(W);
			bw.write(res + "\n");

		}

		bw.flush();

	}

	public static long getMinTime(int W) {

		long[] time = new long[N + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {

			int n = q.poll();

			if (n == W)
				return time[n] + D[n];

			for (int m : arr[n]) {

				indegree[m]--;

				if (indegree[m] == 0) {
					q.offer(m);
				}

				time[m] = Math.max(time[m], time[n] + D[n]);
			}
		}

		return -1;

	}

}
