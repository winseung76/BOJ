import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02470 {

	static int N;
	static int[] arr;
	static int res1, res2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		mergeSort(0, N - 1);

		solve();

		bw.write(res1 + " " + res2 + "\n");
		bw.flush();

	}

	public static void solve() {

		int s = 0, e = N - 1;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		while (s < e) {

			sum = Math.abs(arr[s] + arr[e]);

			int sum1 = Math.abs(arr[s + 1] + arr[e]);
			int sum2 = Math.abs(arr[s] + arr[e - 1]);

			if (sum < min) {
				min = sum;
				res1 = arr[s];
				res2 = arr[e];
			}

			if (sum < sum1 && sum < sum2) {

				if (sum1 < sum2)
					s++;
				else
					e--;
			} 
			else {

				if (sum >= sum1)
					s++;

				else if (sum >= sum2)
					e--;
			}
		}

	}

	public static void mergeSort(int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(left, center);
			mergeSort(center + 1, right);

			int size = center - left + 1;
			int[] buf = new int[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl] < arr[pr]) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

}
