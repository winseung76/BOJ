import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 이분 탐색 - 탐색하려는 값이 배열에 여러 개 있는 경우
public class n10816 {

	static int[] arr;
	static int[] count = new int[20000001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] s = br.readLine().split(" ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			count[arr[i]+10000000]++;
		}

		mergeSort(arr, 0, N - 1);

		int M = Integer.parseInt(br.readLine());
		s = br.readLine().split(" ");

		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(s[i]);

			bw.write(binSearch(arr, N, n) + " ");

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

	public static int binSearch(int[] arr, int size, int key) {

		int pl = 0;
		int pr = size - 1;

		do {
			int pc = (pl + pr) / 2;

			if (arr[pc] == key)
				return count[arr[pc]+10000000];

			else if (arr[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;

		} while (pl <= pr);

		return 0;
	}
}
