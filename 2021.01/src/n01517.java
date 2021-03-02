import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01517 {

	static int N;
	static int[] arr;
	static long cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		mergeSort(0, N - 1);

		bw.write(cnt + "\n");
		bw.flush();

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

			while (pl < size && pr <= right) {
				if (buf[pl] > arr[pr])
					cnt += pr - k;

				arr[k++] = buf[pl] <= arr[pr] ? buf[pl++] : arr[pr++];
			}

			while (pl < size)
				arr[k++] = buf[pl++];

		}

	}

}
