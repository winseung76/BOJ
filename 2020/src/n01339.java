import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01339 {

	public static void main(String[] args) throws Exception {

		int res = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[26];

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {

			String s = br.readLine();

			for (int j = 0; j < s.length(); j++) {

				char c = s.charAt(j);
				arr[c - 65] += Math.pow(10, s.length() - 1 - j);
			}
		}

		mergeSort(arr, 0, arr.length - 1);

		int k = 9;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				res += arr[i] * k;
				k--;
			}
		}
		bw.write(res + "\n");
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

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl] > arr[pr]) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}
}
