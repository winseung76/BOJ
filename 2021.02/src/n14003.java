import java.io.*;
import java.util.*;

public class n14003 {

	static int N;
	static List<Integer> list = new ArrayList<>();
	static Pair[] track;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		track = new Pair[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(sarr[i]);

			if (list.size() == 0 || list.get(list.size() - 1) < n) {
				list.add(n);
				track[i] = new Pair(n, list.size() - 1);
			} else {
				int idx = binSearch(n, 0, list.size() - 1);
				list.set(idx, n);
				track[i] = new Pair(n, idx);
			}
		}

		int idx = list.size() - 1;
		for (int i = N - 1; i >= 0; i--) {
			if (track[i].idx == idx) {
				list.set(idx, track[i].n);
				idx--;
			}
		}

		bw.write(list.size() + "\n");
		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + " ");
		bw.flush();

	}

	public static int binSearch(int n, int left, int right) {

		int pl = left;
		int pr = right;

		do {

			int pc = (pl + pr) / 2;

			if (list.get(pc) == n)
				return pc;

			if (list.get(pc) < n)
				pl = pc + 1;
			else if (list.get(pc) > n)
				pr = pc - 1;

		} while (pl <= pr);

		return pl;
	}

	static class Pair {

		int n, idx;

		Pair(int n, int idx) {
			this.n = n;
			this.idx = idx;
		}
	}
}
