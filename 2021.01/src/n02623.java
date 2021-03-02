import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n02623 {

	static int N, M;
	static int[] indegree;
	static Vector<Integer>[] arr;

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
			int cnt = Integer.parseInt(s[0]);

			if (cnt > 0) {
				int preN = Integer.parseInt(s[1]);

				for (int j = 2; j <= cnt; j++) {
					int n = Integer.parseInt(s[j]);
					arr[preN].add(n);
					indegree[n]++;
					preN = n;
				}
			}
		}

		Queue<Integer> res = getOrder();

		if (res.size() < N)
			bw.write(0 + "\n");
		else {
			while (!res.isEmpty()) {
				bw.write(res.poll() + "\n");
			}
		}
		bw.flush();

	}

	public static Queue<Integer> getOrder() {

		Queue<Integer> q = new LinkedList<>();
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
