import java.io.*;
import java.util.*;

public class n01208 {

	static int N, S;
	static long[] arr;
	static List<Long> sum1 = new ArrayList<>();
	static List<Long> sum2 = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		getSubsequence(0, N / 2, 0, sum1);
		getSubsequence(N / 2, N, 0, sum2);

		Collections.sort(sum1);
		Collections.sort(sum2);

		long cnt = twoPointer();

		if (S == 0)
			cnt--;

		bw.write(cnt + "\n");
		bw.flush();

	}

	public static void getSubsequence(int idx, int end, long sum, List<Long> list) {

		if (idx == end) {
			list.add(sum);
			return;
		}

		getSubsequence(idx + 1, end, sum + arr[idx], list);
		getSubsequence(idx + 1, end, sum, list);

	}

	public static long twoPointer() {

		int s = 0;
		int e = sum2.size() - 1;
		long cnt = 0;

		while (s < sum1.size() && e >= 0) {

			long sum = sum1.get(s) + sum2.get(e);

			if (sum < S)
				s++;
			else if (sum > S)
				e--;
			else {
				long cnt1 = 0;
				long n = sum1.get(s);
				while (s < sum1.size() && sum1.get(s) == n) {
					s++;
					cnt1++;
				}

				long cnt2 = 0;
				long m = sum2.get(e);
				while (e >= 0 && sum2.get(e) == m) {
					e--;
					cnt2++;
				}

				cnt += cnt1 * cnt2;
			}
		}

		return cnt;

	}

}
