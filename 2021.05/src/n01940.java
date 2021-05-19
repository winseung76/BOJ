import java.io.*;
import java.util.Arrays;

public class n01940 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int s = 0;
		int e = N - 1;
		int sum = 0;
		int cnt = 0;

		while (s < e) {

			sum = arr[s] + arr[e];

			if (sum == M) {
				int cnt1 = 0;
				int cnt2 = 0;
				int v1 = arr[s];
				int v2 = arr[e];
				while (s < N && arr[s] == v1) {
					s++;
					cnt1++;
				}
				while (e >= 0 && arr[e] == v2) {
					e--;
					cnt2++;
				}

				cnt += cnt1 * cnt2;
			}

			else if (sum > M)
				e--;

			else if (sum < M)
				s++;

		}

		return cnt;
	}

}
