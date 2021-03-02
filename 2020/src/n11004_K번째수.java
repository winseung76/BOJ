import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11004_K¹øÂ°¼ö {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int[] arr = new int[N];

		s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		heapsort(arr);

		bw.write(arr[K - 1] + "\n");
		bw.flush();

	}

	static void heapify(int[] arr, int n, int i) {
		int p = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;

		if (l < n && arr[p] < arr[l])
			p = l;
		if (r < n && arr[p] < arr[r])
			p = r;

		if (i != p) {
			swap(arr, i, p);
			heapify(arr, n, p);
		}
	}

	static void heapsort(int[] arr) {

		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		for (int i = n - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
