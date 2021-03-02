import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n07453 {

	static int[] a, b, c, d;
	static int[] arr1, arr2;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		c = new int[n];
		d = new int[n];
		arr1 = new int[n * n];
		arr2 = new int[n * n];

		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			a[i] = Integer.parseInt(s[0]);
			b[i] = Integer.parseInt(s[1]);
			c[i] = Integer.parseInt(s[2]);
			d[i] = Integer.parseInt(s[3]);

		}
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr1[k] = a[i] + b[j];
				arr2[k] = c[i] + d[j];
				k++;
			}
		}
		mergeSort(arr1, 0, arr1.length - 1);
		mergeSort(arr2, 0, arr2.length - 1);

		bw.write(getCount() + "\n");
		bw.flush();

	}

	public static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

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

	public static long getCount() {

		long count = 0;
		int s = 0, e = arr2.length - 1;

		while (s < arr1.length && e >= 0) {

			long sum = arr1[s] + arr2[e];

			if (sum == 0) {
				int a = arr1[s];
				int b = arr2[e];
				long abcnt = 0, cdcnt = 0;

				while (s < arr1.length && arr1[s] == a) {
					s++;
					abcnt++;
				}
				while (e >= 0 && arr2[e] == b) {
					e--;
					cdcnt++;
				}
				count += abcnt * cdcnt;
			}

			else if (sum > 0 || s == arr1.length - 1)
				e--;

			else if (sum < 0 || e == 0)
				s++;
		}

		return count;

	}

}
