import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11557 {

	static Pair[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new Pair[N];

			for (int j = 0; j < N; j++) {
				String[] s = br.readLine().split(" ");
				arr[j] = new Pair(s[0], Integer.parseInt(s[1]));
			}
			mergeSort(0, N - 1);
			bw.write(arr[0].name + "\n");
		}
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
				buf[i - left] = arr[i];

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				arr[k++] = (buf[pl].compareTo(arr[pr]) < 0) ? buf[pl++] : arr[pr++];

			while (pl < size)
				arr[k++] = buf[pl++];

		}

	}

	static class Pair implements Comparable<Pair> {
		String name;
		int n;

		Pair(String name, int n) {
			this.name = name;
			this.n = n;
		}

		@Override
		public int compareTo(Pair o) {

			return o.n - n;
		}
	}

}
