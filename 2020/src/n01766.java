import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

public class n01766 {

	static int N, M;
	static Vector<Integer>[] arr;
	static int[] indegree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new Vector[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = new Vector();
		indegree = new int[N + 1];

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			arr[a].add(b);
			indegree[b]++;
		}

		Queue<Integer> res = getOrder();

		while (!res.isEmpty()) {
			bw.write(res.poll() + " ");
		}
		bw.flush();

	}

	public static Queue<Integer> getOrder() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		Queue<Integer> res = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {

			int n = q.poll();
			res.offer(n);

			for (int m : arr[n]) {
				indegree[m]--;

				if (indegree[m] == 0)
					q.offer(m);
			}

		}

		return res;
	}

}
