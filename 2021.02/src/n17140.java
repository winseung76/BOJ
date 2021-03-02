import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class n17140 {

	static int r, c, k;
	static int[][] A = new int[101][101];
	static int rowLen = 3;
	static int colLen = 3;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		r = Integer.parseInt(sarr[0]);
		c = Integer.parseInt(sarr[1]);
		k = Integer.parseInt(sarr[2]);

		for (int i = 1; i <= 3; i++) {
			sarr = br.readLine().split(" ");
			for (int j = 1; j <= 3; j++) {
				A[i][j] = Integer.parseInt(sarr[j - 1]);
			}
		}

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static int solve() {

		int time = 0;

		while (time <= 100) {

			if (A[r][c] == k)
				return time;

			if (rowLen >= colLen) {
				int maxLen = 0;
				int[][] tmp = new int[rowLen + 1][];

				for (int i = 1; i <= rowLen; i++) {

					Vector<Pair> list = new Vector<>();
					int[] arr = new int[101];
					for (int j = 1; j <= colLen; j++) {
						if (A[i][j] > 0)
							arr[A[i][j]]++;
					}

					for (int j = 1; j <= 100; j++) {
						if (arr[j] > 0)
							list.add(new Pair(j, arr[j]));
					}

					mergeSort(list, 0, list.size() - 1);

					tmp[i] = new int[list.size() * 2 + 1];
					int idx = 1;
					for (int j = 0; j < list.size(); j++) {
						tmp[i][idx++] = list.get(j).n;
						tmp[i][idx++] = list.get(j).cnt;
					}
					maxLen = Math.max(maxLen, tmp[i].length - 1);
				}
				colLen = maxLen;

				for (int i = 1; i <= rowLen; i++) {
					for (int j = 1; j <= colLen; j++) {
						if (j >= tmp[i].length)
							A[i][j] = 0;
						else
							A[i][j] = tmp[i][j];
					}
				}
			}

			else {
				int maxLen = 0;
				int[][] tmp = new int[colLen + 1][];

				for (int i = 1; i <= colLen; i++) {
					Vector<Pair> list = new Vector<>();
					int[] arr = new int[101];

					for (int j = 1; j <= rowLen; j++) {
						if (A[j][i] > 0)
							arr[A[j][i]]++;
					}

					for (int j = 1; j <= 100; j++) {
						if (arr[j] > 0)
							list.add(new Pair(j, arr[j]));
					}

					mergeSort(list, 0, list.size() - 1);

					tmp[i] = new int[list.size() * 2 + 1];

					int idx = 1;
					for (int j = 0; j < list.size(); j++) {
						tmp[i][idx++] = list.get(j).n;
						tmp[i][idx++] = list.get(j).cnt;
					}

					maxLen = Math.max(maxLen, tmp[i].length - 1);
				}

				rowLen = maxLen;

				for (int i = 1; i <= colLen; i++) {
					for (int j = 1; j <= rowLen; j++) {
						if (j >= tmp[i].length)
							A[j][i] = 0;
						else
							A[j][i] = tmp[i][j];
					}
				}

			}
			time++;

		}

		return -1;
	}

	public static void mergeSort(Vector<Pair> list, int left, int right) {

		if (left < right) {

			int center = (left + right) / 2;

			mergeSort(list, left, center);
			mergeSort(list, center + 1, right);

			int size = center - left + 1;
			Pair[] buf = new Pair[size];

			for (int i = left; i <= center; i++)
				buf[i - left] = list.get(i);

			int pl = 0, pr = center + 1;
			int k = left;

			while (pl < size && pr <= right)
				list.set(k++, buf[pl].compareTo(list.get(pr)) < 0 ? buf[pl++] : list.get(pr++));

			while (pl < size)
				list.set(k++, buf[pl++]);

		}
	}

	static class Pair implements Comparable<Pair> {

		int n, cnt;

		Pair(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Pair o) {

			if (cnt == o.cnt)
				return n - o.n;

			return cnt - o.cnt;
		}
	}

}
