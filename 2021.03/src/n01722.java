import java.io.*;
import java.util.*;

public class n01722 {

	static int N;
	static boolean[] visited;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		String[] sarr = br.readLine().split(" ");

		int n = Integer.parseInt(sarr[0]);
		List<Integer> list = new ArrayList<>();

		if (n == 1) {
			int k = Integer.parseInt(sarr[1]);

			solve(list, k);

		} else if (n == 2) {
			arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(sarr[i + 1]);

			solve(list);
		}

	}

	public static void solve(List<Integer> list, int k) {

		if (list.size() == N) {

			cnt++;

			if (cnt == k) {
				for (int n : list)
					System.out.print(n + " ");
				System.out.println();
			}

			return;
		}

		for (int n = 1; n <= N; n++) {
			if (!visited[n]) {
				visited[n] = true;
				list.add(n);

				solve(list, k);

				visited[n] = false;
				list.remove(list.size() - 1);
			}
		}

	}

	public static void solve(List<Integer> list) {

		if (list.size() == N) {

			cnt++;

			boolean flag = true;
			for (int i = 0; i < N; i++) {
				if (list.get(i) != arr[i]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println(cnt);
			}
			return;
		}

		for (int n = 1; n <= N; n++) {
			if (!visited[n]) {
				visited[n] = true;
				list.add(n);

				solve(list);

				visited[n] = false;
				list.remove(list.size() - 1);
			}
		}
	}

}
