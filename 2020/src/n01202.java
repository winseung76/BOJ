import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class n01202 {

	static Pair[] arr;
	static int[] bags;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);

		arr = new Pair[N];
		bags = new int[K];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int m = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			arr[i] = new Pair(m, v);
		}

		for (int i = 0; i < K; i++)
			bags[i] = Integer.parseInt(br.readLine());

		mergeSort(arr, 0, N - 1);
		Arrays.sort(bags);

		long sum = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < K; i++) {

			int c = bags[i];

			while (idx < N && arr[idx].m <= c) {
				pq.add(arr[idx].v);
				idx++;
			}
			if (!pq.isEmpty())
				sum += pq.poll();
		}
		bw.write(sum + "\n");
		bw.flush();

	}

	public static void mergeSort(Pair[] arr, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, right);

			int size = center - left + 1;
			Pair[] buf = new Pair[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl].compareTo(arr[pr]) < 0) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];
		}
	}

	static class Pair implements Comparable {
		int m;
		int v;

		Pair(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Object o) {

			return m - ((Pair) o).m;
		}

	}
}
