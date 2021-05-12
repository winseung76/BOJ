import java.io.*;
import java.util.*;

// 배열에 중복되는 수가 있을 때 : 중복조합을 제거할 때
public class n15663 {

	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N];
		visited = new boolean[N];
		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		List<Integer> list = new ArrayList<>();
		solve(list);
		bw.flush();

	}

	public static void solve(List<Integer> list) throws Exception {

		if (list.size() == M) {
			for (int n : list) {
				bw.write(n + " ");
			}
			bw.write("\n");
			return;
		}

		int overlap = 0;

		for (int i = 0; i < N; i++) {
			if (!visited[i] && overlap != arr[i]) {
				visited[i] = true;
				list.add(arr[i]);
				overlap = arr[i];

				solve(list);

				list.remove(list.size() - 1);
				visited[i] = false;
			}
		}
	}
}
