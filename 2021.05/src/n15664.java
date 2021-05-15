import java.io.*;
import java.util.*;

public class n15664 {

	static int N, M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N];

		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);
		solve(0, new ArrayList<>());
		bw.flush();

	}

	public static void solve(int idx, List<Integer> list) throws Exception {

		int overlap = 0;

		if (list.size() == M) {

			for (int n : list) {
				bw.write(n + " ");
			}
			bw.write("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			if (overlap != arr[i]) {
				list.add(arr[i]);
				solve(i + 1, list);
				list.remove(list.size() - 1);
				overlap = arr[i];
			}
		}
	}

}
