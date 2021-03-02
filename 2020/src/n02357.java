import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02357 {

	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Tree tree = new Tree();
		tree.init(1, 1, N);

		for (int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);

			Pair pair = tree.getPair(1, 1, N, a, b);
			bw.write(pair.min + " " + pair.max + "\n");
		}
		bw.flush();

	}

	static class Tree {
		Pair[] tree = new Pair[4 * N];

		public Pair init(int node, int start, int end) {

			if (start == end)
				return tree[node] = new Pair(arr[start], arr[start]);

			int mid = (start + end) / 2;

			Pair lp = init(node * 2, start, mid);
			Pair rp = init(node * 2 + 1, mid + 1, end);

			int min = Math.min(lp.min, rp.min);
			int max = Math.max(lp.max, rp.max);

			return tree[node] = new Pair(min, max);
		}

		public Pair getPair(int node, int start, int end, int left, int right) {
			if (left > end || right < start)
				return null;

			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;

			Pair lp = getPair(node * 2, start, mid, left, right);
			Pair rp = getPair(node * 2 + 1, mid + 1, end, left, right);

			if (lp == null)
				return rp;

			if (rp == null)
				return lp;

			return new Pair(Math.min(lp.min, rp.min), Math.max(lp.max, rp.max));
		}
	}

	static class Pair {
		int min, max;

		Pair(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

}
