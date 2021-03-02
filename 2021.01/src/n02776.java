import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02776 {

	static int[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];

			String[] sarr = br.readLine().split(" ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(sarr[i]);

			mergeSort(0, N - 1);

			int M = Integer.parseInt(br.readLine());
			sarr = br.readLine().split(" ");

			for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(sarr[i]);

				int res = binSearch(n, 0, N - 1);

				if (res == -1)
					bw.write(0 + "\n");
				else
					bw.write(1 + "\n");
			}

		}
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

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl] < arr[pr]) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}
	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (arr[pc] == n)
				return pc;

			if (arr[pc] < n)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return -1;
	}

}
