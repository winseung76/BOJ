import java.io.*;
import java.util.*;

public class n02473 {

	static int N;
	static long[] arr;
	static long min = Long.MAX_VALUE;
	static int idx1, idx2, idx3;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new long[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(input[i]);
		}

		Arrays.sort(arr);
		for (int i = N - 2; i >= 0; i--) {
			solve(i);
		}

		List<Long> list = new ArrayList<>();
		list.add(arr[idx1]);
		list.add(arr[idx2]);
		list.add(arr[idx3]);
		Collections.sort(list);

		for (long n : list) {
			bw.write(n + " ");
		}
		bw.flush();

	}

	public static void solve(int end) {

		int s = 0;
		int e = end;

		while (s < e) {

			long sum = arr[s] + arr[e] + arr[end + 1];

			if (Math.abs(sum) < Math.abs(min)) {
				min = sum;
				idx1 = s;
				idx2 = e;
				idx3 = end + 1;
			}

			if (sum > 0)
				e--;
			else
				s++;

		}
	}
}
