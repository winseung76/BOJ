import java.io.*;

public class n05800 {

	static int K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int[] arr = new int[N];

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(input[j + 1]);
			}

			mergeSort(arr, 0, N - 1);

			int diff = 0;
			for (int j = 0; j < N - 1; j++) {
				diff = Math.max(diff, arr[j] - arr[j + 1]);
			}

			bw.write("Class " + (i + 1) + "\n");
			bw.write("Max " + arr[0] + ", Min " + arr[N - 1] + ", Largest gap " + diff + "\n");

		}
		bw.flush();

	}

	public static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			int size = center - left + 1;
			int[] buf = new int[size];

			for (int i = left; i <= center; i++) {
				buf[i - left] = arr[i];
			}

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right) {
				arr[k++] = (buf[pl] > arr[pr]) ? buf[pl++] : arr[pr++];
			}

			while (pl < size) {
				arr[k++] = buf[pl++];
			}
		}
	}

}
