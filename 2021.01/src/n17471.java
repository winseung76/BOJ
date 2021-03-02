import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class n17471 {

	static int N;
	static int[] people;
	static Vector<Integer>[] arr;
	static int all;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		people = new int[N + 1];
		arr = new Vector[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new Vector<>();
		}

		String[] sarr = br.readLine().split(" ");

		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(sarr[i - 1]);
			all += people[i];
		}

		for (int i = 1; i <= N; i++) {
			sarr = br.readLine().split(" ");
			int n = Integer.parseInt(sarr[0]);

			for (int j = 1; j <= n; j++) {
				arr[i].add(Integer.parseInt(sarr[j]));
			}
		}

		for (int cnt = 1; cnt < N; cnt++) {
			Vector<Integer> list = new Vector<>();
			solve(list, 0, 1, cnt);
		}

		if (min == Integer.MAX_VALUE)
			min = -1;

		bw.write(min + "\n");
		bw.flush();
	}

	public static void solve(Vector<Integer> list, int sum, int n, int cnt) {

		if (list.size() == cnt) {

			Vector<Integer> list2 = new Vector<>();
			for (int i = 1; i <= N; i++) {
				if (!list.contains(i))
					list2.add(i);
			}

			if (bfs(list) && bfs(list2))
				min = Math.min(min, Math.abs(sum - (all - sum)));
			return;
		}

		for (int i = n; i <= N; i++) {
			list.add(i);
			solve(list, sum + people[i], i + 1, cnt);
			list.remove((Integer) i);
		}

	}

	public static boolean bfs(Vector<Integer> list) {

		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		visited[list.get(0)] = true;
		q.offer(list.get(0));

		while (!q.isEmpty()) {
			int n = q.poll();

			for (int m : arr[n]) {
				if (list.contains(m) && !visited[m]) {
					visited[m] = true;
					q.offer(m);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (!visited[list.get(i)])
				return false;
		}
		return true;
	}

}
