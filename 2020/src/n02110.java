import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02110 {

	static int[] arr, range;
	static int N, C;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr, 0, N - 1);

		int max = arr[N - 1] - arr[0];
		int min = 1;

		int res = binSearch(min, max + 1);
		bw.write(res + "\n");

		bw.flush();

	}

	public static int binSearch(int left, int right) {

		int pl = left;
		int pr = right - 1;
		int pc;

		do {
			pc = (pl + pr) / 2;

			if (setWifi(pc))
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return pr;
	}

	public static boolean setWifi(int diff) {

		int start = arr[0];
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			int end = arr[i];
			int d = end - start;
			if (diff <= d) {
				cnt++;
				start = end;
			}
		}
		if (cnt >= C)
			return true;

		return false;
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

}
