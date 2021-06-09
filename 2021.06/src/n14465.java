import java.io.*;
import java.util.*;

public class n14465 {

	static int N, K, B;
	static int[] arr, diff;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		B = Integer.parseInt(input[2]);

		arr = new int[B + 2];
		arr[0] = 0;
		for (int i = 1; i <= B; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[B + 1] = N + 1;

		Arrays.sort(arr);

		diff = new int[B + 1];
		for (int i = 0; i < B + 1; i++) {
			diff[i] = arr[i + 1] - arr[i] - 1;
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int s = 0;
		int e = 0;
		int sum = 0;
		int min = B;

		while (s < diff.length) {

			if (sum + e - s - 1 >= K || e == diff.length) {
				if (sum + e - s - 1 >= K) {
					min = Math.min(min, e - s - 1);
				}
				sum -= diff[s++];
			}

			else {
				sum += diff[e++];
			}
		}

		return min;
	}

}
