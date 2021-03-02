import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02751_수정렬하기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		heap_sort(arr);

		for (int i = 0; i < N; i++)
			bw.write(arr[i] + "\n");
		bw.flush();
	}

	public static void heap_sort(int[] arr) {

		int size = arr.length;

		for (int i = size / 2 - 1; i >= 0; i--) {
			heapify(arr, size, i);
		}

		for (int i = size - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}

	}

	public static void heapify(int[] arr, int size, int i) {
		int p = i;
		int lc = 2 * i + 1;
		int rc = 2 * i + 2;

		if (rc < size && arr[p] < arr[rc])
			p = rc;

		if (lc < size && arr[p] < arr[lc])
			p = lc;

		if (p != i) {
			swap(arr, p, i);
			heapify(arr, size, p);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
