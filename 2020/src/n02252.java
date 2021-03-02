import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class n02252 {

	static int N, M;
	static int[] indegree;
	static List<Integer>[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		indegree = new int[N + 1];
		arr = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			arr[a].add(b);
			indegree[b]++;
		}

		Queue<Integer> result = getOrder();

		while (!result.isEmpty()) {
			bw.write(result.poll() + " ");
		}
		bw.flush();

	}

	public static Queue<Integer> getOrder() {

		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int n = q.poll();
			result.offer(n);

			for (int i = 0; i < arr[n].size(); i++) {
				int m = arr[n].get(i);

				indegree[m]--;

				if (indegree[m] == 0)
					q.offer(m);
			}
		}

		return result;

	}
}
