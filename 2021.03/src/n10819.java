import java.io.*;
import java.util.*;

public class n10819 {

	static int N;
	static boolean[] visited;
	static int[] arr;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		arr = new int[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		List<Integer> list = new ArrayList<>();
		solve(list);

		bw.write(max + "\n");
		bw.flush();

	}

	public static void solve(List<Integer> list) {

		if (list.size() == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(list.get(i) - list.get(i + 1));
			}
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				list.add(arr[i]);
				visited[i] = true;

				solve(list);

				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}

}
