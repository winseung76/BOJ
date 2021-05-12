import java.io.*;
import java.util.*;

public class n15655 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N];

		input = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		solve(0, list);

	}

	public static void solve(int idx, List<Integer> list) {

		if (list.size() == M) {
			for (int n : list) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}

		for (int i = idx; i < N; i++) {
			list.add(arr[i]);
			solve(i + 1, list);
			list.remove(list.size() - 1);
		}

	}

}
