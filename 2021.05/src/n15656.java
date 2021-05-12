import java.io.*;
import java.util.*;

public class n15656 {

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

		for (int i = 0; i < N; i++) {
			list.add(arr[i]);
			solve(list);
			list.remove(list.size() - 1);
		}
	}

}
