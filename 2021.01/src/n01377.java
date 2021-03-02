import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Vector;

public class n01377 {

	static int N;
	static Vector<Pair> before = new Vector<>();
	static Vector<Pair> after = new Vector<>();
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			before.add(new Pair(n, i));
			after.add(new Pair(n, i));
		}

		mergeSort(0, N - 1);

		int max = 0;
		for (int i = 0; i < N; i++) {

			if (i < after.get(i).idx)
				max = Math.max(max, after.get(i).idx - i);
		}

		bw.write(max + 1 + "\n");
		bw.flush();

	}

	public static void mergeSort(int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(left, center);
			mergeSort(center + 1, right);

			int size = center - left + 1;
			Pair[] buf = new Pair[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = after.get(i);

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				after.set(k++, (buf[pl].compareTo(after.get(pr)) <= 0) ? buf[pl++] : after.get(pr++));

			while (pl < size)
				after.set(k++, buf[pl++]);

		}

	}

	static class Pair implements Comparable<Pair> {

		int n, idx;

		Pair(int n, int idx) {
			this.n = n;
			this.idx = idx;
		}

		@Override
		public int compareTo(Pair o) {

			return n - o.n;
		}
	}

}
